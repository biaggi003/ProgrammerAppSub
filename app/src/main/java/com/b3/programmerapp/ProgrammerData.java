package com.b3.programmerapp;

import java.util.ArrayList;

public class ProgrammerData {
    public static String[][] data = new String[][]{
            {"James Gosling", "Penemu Bahasa Pemrograman Java", "https://upload.wikimedia.org/wikipedia/commons/thumb/1/14/James_Gosling_2008.jpg/596px-James_Gosling_2008.jpg", "James A. Gosling O.C., Ph.D. adalah seorang pengembang perangkat lunak, yang terkenal terutama sebagai bapak bahasa pemograman Java.","19 Mei 1955, Calgary, Alberta, Kanada","-","Carnegie Mellon University, University of Calgary"},
            {"Dennis Ritchie", "Penemu Bahasa Pemrograman C", "https://upload.wikimedia.org/wikipedia/commons/2/23/Dennis_Ritchie_2011.jpg","Dennis MacAlistair Ritchie adalah seorang ilmuwan komputer yang dikenal atas sumbangsihnya membuat bahasa pemrograman C dan berbagai sistem operasi seperti Multics dan Unix. Ritchie menerima penghargaan Turing Award pada tahun 1983 dan National Medal of Technology 1998 pada 21 April 1999.","9 September 1941, Bronxville, New York, United States","12 Oktober 2011, Berkeley Heights, New Jersey, United States","John A. Paulson School Of Engineering And Applied Sciences, Summit High School, Harvard University"},
            {"Brendan Eich", "Penemu Bahasa Pemrograman Javascript", "https://upload.wikimedia.org/wikipedia/commons/d/d1/Brendan_Eich_Mozilla_Foundation_official_photo.jpg","Brendan Eich adalah teknolog Amerika dan pencipta bahasa pemrograman JavaScript. Dia juga Co-Founder dari proyek Mozilla, Mozilla Foundation, Mozilla Corporation, dan menjabat sebagai Chief Technical Officer di Mozilla Corporation dan Chief Executive Officer untuk sementara waktu. Dia juga CEO dari Brave Software.","4 Juli 1961, Pittsburgh, Pennsylvania, United States","-","Ellwood P. Cubberley High School, University of Illinois at Urbana-Champaign, Santa Clara University"},
            {"Rasmus Lerdorf", "Penemu Bahasa Pemrograman PHP", "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9c/Rasmus_Lerdorf_cropped.jpg/443px-Rasmus_Lerdorf_cropped.jpg","Rasmus Lerdorf merupakan seorang pemrogram dari Denmark/Greenland dan pencipta bahasa pemrograman PHP. Rasmus menulis dua versi pertama dari PHP.","22 November 1968, Qeqertarsuaq, Greenland","-","King City Secondary School, University of Waterloo"},
            {"Guido van Rossum", "Penemu Bahasa Pemrograman Python", "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d0/Guido-portrait-2014-curvves.jpg/800px-Guido-portrait-2014-curvves.jpg","Guido van Rossum adalah programmer komputer berkewarganegaraan Belanda yang lebih di kenal sebagai pencipta dan \"Benevolent Dictator for Life\" dari bahasa pemrograman Python yang artinya dia hanya akan memberikan keputusan akhir jika dibutuhkan.","31 January 1956, Haarlem, Netherlands","-","University of Amsterdam"},
            {"Niklaus Wirth", "Penemu Bahasa Pemrograman Pascal", "https://upload.wikimedia.org/wikipedia/commons/thumb/4/49/Niklaus_Wirth%2C_UrGU.jpg/784px-Niklaus_Wirth%2C_UrGU.jpg","Niklaus Wirth adalah perancang utama bahasa pemgrograman Algol W, Pascal, Modula, Modula-2, dan Oberon. Atas pengembangan bahasa-bahasa ini, ia meraih penghargaan ACM Turing Award.","15 Februari 1934, Winterthur, Switzerland","-","University of California, Berkeley (1963), Laval University (1960), ETH Zürich"},
    };

    public static ArrayList<Programmer> getListData(){
        Programmer programmer;
        ArrayList<Programmer> list = new ArrayList<>();
        for (String[] aData : data) {
            programmer = new Programmer();
            programmer.setName(aData[0]);
            programmer.setRemarks(aData[1]);
            programmer.setPhoto(aData[2]);
            programmer.setContent(aData[3]);
            programmer.setLahir(aData[4]);
            programmer.setWafat(aData[5]);
            programmer.setPendidikan(aData[6]);

            list.add(programmer);
        }

        return list;
    }
}
