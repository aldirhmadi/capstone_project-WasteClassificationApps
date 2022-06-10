import tensorflow as tf
from tensorflow import keras
import numpy as np
import io
from PIL import Image
from flask import Flask, jsonify, request
import os

model_path = 'model_v5.h5'
model = keras.models.load_model(model_path)

class_dict = {0: 'Battery',
              1: 'Cardboard',
              2: 'Clothes',
              3: 'E-Waste',
              4: 'Food',
              5: 'Glass',
              6: 'Light Bulbs',
              7: 'Metal',
              8: 'Paper',
              9: 'Plastic',
              10: 'Shoes'}

def waste_predict(rawImg, model):
    image = rawImg.resize((224, 224))
    x = keras.utils.img_to_array(image)
    x = np.expand_dims(x, axis = 0)
    preds = model.predict(x)

    return class_dict.get(np.argmax(preds))

details = [
    [
        "Sampah organik adalah sampah dari bahan-bahan hayati yang bisa didegradasi oleh mikroba atau bersifat biodegradable. Sampah ini mudah diurai dengan proses alami.",

        "Jenis sampah rumah tangga sebagian besar termasuk kelompok sampah organik. Beberapa sampah organik misalnya sampah dapur, sisa makanan, kulit buah, daun, ranting, sayuran, dan buah-buahan.",

        "Sampah organik yang tidak terkelola, selain menimbulkan bau tidak sedap dan mengganggu estetika, juga menjadi media perkembangbiakan vektor dan hewan pengerat. Hal ini dapat menimbulkan berbagai macam penyakit yang berbahaya bagi kesehatan karena hewan-hewan ini membawa aneka penyakit menular melalui bakteri atau virus. Selain itu, sampah organik juga dapat memicu terjadinya pemanasan global (Global Warming). Sampah organik yang dibiarkan menumpuk di tempat pembuangan akhir tanpa sirkulasi oksigen dan tidak terurai, akan melepaskan gas metana yang 21 kali lebih berbahaya ke lapisan ozon dibandingkan dengan karbondioksida karena menyerap panas lebih banyak.",

        "Memisahkan sampah organik dengan jenis sampah lainnya. Habiskan dan makanlah makanan secukupnya, karena sisa makanan dapat menjadi sampah organik. Ubahlah sampah organik menjadi kompos yang dapat digunakan kembali sebagai pupuk tanaman.",

        "Membiarkan sampah organik menumpuk dan tidak mengelolanya dengan benar sehingga menjadi sarang bagi berbagai macam hewan pembawa bermacam penyakit dan dapat menimbulkan gas metana yang dapat merusak lapisan ozon."
    ],

    [
        "Sampah anorganik adalah sampah yang berasal dari bahan non hayati termasuk produk sintesis dan hasil proses teknologi pengolahan bahan tambang.",

        "Sampah anorganik yaitu sampah logam dan produk olahannya, sampah plastik, kaca, keramik, dan detergen. Sebagian besar sampah non organik ini tidak bisa diurai oleh alam atau mikroorganisme. Sebagian lainnya, sampah anorganik bisa diurai, namun butuh waktu yang lama. Jenis sampah anorganik yang bisa urai dalam waktu lama misalnya botol plastik, botol gelas, tas plastik, dan kaleng.",

        "Sampah anorganik dapat menyebabkan berbagai gangguan kesehatan, seperti diare, demam, hingga infeksi. Selain itu, sampah anorganik yang dibiarkan menumpuk tanpa penanganan lebih lanjut juga dapat menimbulkan banjir akibat tersumbatnya aliran sungai. Sampah anorganik sangat mencemari lingkungan karena dapat menyumbat drainase dan mencemari air. Sampah anorganik juga dapat menurunkan kualitas hidup masyarakat karena lingkungan menjadi tidak sehat dan tidak bersih.",

        "Memisahkan antara sampah anorganik dengan jenis sampah lainnya. Mendaur ulang sampah anorganik menjadi barang lain yang dapat dimanfaatkan kembali. Meminimalisir penggunaan bahan-bahan yang sulit terurai, seperti plastik.",

        "Menggunakan terlalu banyak bahan yang dapat menimbulkan sampah anorganik, contohnya plastik dan baterai. Membuang sampah organik secara sembarangan dan tidak mengelolanya dengan benar. Sampah anorganik sangat sulit terurai, sehingga jika tidak ditangani dengan benar akan menumpuk dan mencemari lingkungan."
    ],

    [
        "Sampah Bahan Berbahaya dan Beracun (B3) adalah limbah yang mengandung bahan berbahaya dan atau beracun karena sifat, konsentrasi, atau jumlahnya. Sampah tersebut bisa merusak dan mencemari lingkungan baik langsung atau tidak langsung. Bagi lingkungan dampak dari jenis lingkungan B3 ini sangat besar dan bersifat akumulatif jika dibuang langsung ke lingkungan. Sampah jenis ini menjadi sumber pencemaran utama di kota yang banyak kegiatan industri.",

        "Bekas pengharum ruangan, pemutih pakaian, deterjen pakaian, pembersih kamar mandi, pembersih kaca/jendela, pembersih lantai, pengkilat kayu, pembersih oven, pembasmi serangga, lem perekat, hair spray, dan batu baterai.",

        "Sampah B3 berdampak buruk bagi kelangsungan hidup manusia, hewan, dan tumbuhan akibat zat beracun dan berbahaya yang dihasilkannya. Dampak buruk ini akan dialami melalui pencemaran sampah B3 terhadap tanah, air, maupun udara.",

        "Oleh karena itu, pisahkan sampah B3 dari sampah yang lain dan buang jauh dari pemukiman. Jika ada, serahkan sampah B3 ke penyedia jasa yang ahli mengolah sampah B3.",

        "Jangan campur sampah B3 agar tidak mencemari sampah yang lain. Jangan buang sampah B3 di lingkungan pertanian dan perkebunan karena dapat mencemari pertumbuhan tanaman. Jangan buang sampah pada saluran air. Jangan bakar sampah B3 karena dapat meledak dan mencemari udara."
    ]
]

app = Flask(__name__)
@app.route('/', methods=['POST'])
def index():
    if request.method == "POST":
        data = {}
        image = request.files.get('image')

        rawImage = Image.open(image)
        pred = waste_predict(rawImage, model)

        data['waste_name'] = pred

        if(pred == 'Food' or pred == 'Cardboard' or pred == 'Paper'):
            data['type'] = 'Organik'
            data['desc'] = details[0][0]
            data['example'] = details[0][1]
            data['impact'] = details[0][2]
            data['do'] = details[0][3]
            data['dont'] = details[0][4]
        

        elif(pred == 'Clothes' or pred == 'Glass' or pred == 'Light Bulbs' or pred == 'Metal' or pred == 'Plastic' or pred == 'Shoes'):
            data['type'] = 'Anorganik'
            data['desc'] = details[1][0]
            data['example'] = details[1][1]
            data['impact'] = details[1][2]
            data['do'] = details[1][3]
            data['dont'] = details[1][4]
        
        else:
            data['type'] = 'B3'
            data['desc'] = details[2][0]
            data['example'] = details[2][1]
            data['impact'] = details[2][2]
            data['do'] = details[2][3]
            data['dont'] = details[2][4]
        
        return jsonify(data) 

if __name__ == '__main__':
    app.run(debug=True)