package feri.com.halopico.data

import android.util.Log
import feri.com.halopico.model.SoalModel

object Data {

    fun ytKondisigetid(s: String): String {
        Log.d("print", "$s")
        return when (s) {
            "Tidak ada perubahan" -> "8r-FUO_nA-U"
            "Risiko gangguan psikologis" -> "JMdhZseLm9U"
            "Perubahan kondisi psikologis" -> "wrz58Jx17JM"
            "Khawatir" -> "cYcdiANgz9k"
            "Sedih" -> "AcTgyPJ5CH4"
            else -> ""
        }
    }

    fun kondisifotoUrl(s: String): String {
        Log.d("print", "$s")
        return when (s) {
            "Tidak ada perubahan" -> "kondisi1"
            "Risiko gangguan psikologis" -> "kondisi2"
            "Perubahan kondisi psikologis" -> "kondisi3"
            "Khawatir" -> "kondisi4"
            "Sedih" -> "kondisi5"
            else -> ""
        }
    }

    fun getDataSoalString() = arrayListOf<SoalModel>(
        SoalModel(
            "SR-001",
            "Apakah anda terpapar/merawat dengan orang yang positif terinfeksi COVID-19",
            0,
            "",
            arrayListOf(
                SoalModel.JawabanModel("Tidak", 0),
                SoalModel.JawabanModel("Ya", 0)
            )
        ),
        SoalModel(
            "SR-002",
            "Apakah anda petugas kesehatan yang merawat pasien COVID-19?",
            0,
            "",
            arrayListOf(
                SoalModel.JawabanModel("Tidak", 0),
                SoalModel.JawabanModel("Ya", 0)
            )
        ),
        SoalModel(
            "SR-003",
            "Apakah anda pernah melakukan perjalanan/pulang dari daerah yang merupakan tempat penularan COVID-19?",
            0,
            "",
            arrayListOf(
                SoalModel.JawabanModel("Tidak", 0),
                SoalModel.JawabanModel("Ya", 0)
            )
        ),
        SoalModel(
            "SR-004",
            "Apakah anda demam diatas 380 C?",
            0,
            "",
            arrayListOf(
                SoalModel.JawabanModel("Tidak", 0),
                SoalModel.JawabanModel("Ya", 0)
            )
        ),
        SoalModel(
            "SR-005",
            "Apakah anda batuk ?",
            0,
            "",
            arrayListOf(
                SoalModel.JawabanModel("Tidak", 0),
                SoalModel.JawabanModel("Ya", 0)
            )
        ),
        SoalModel(
            "SR-006",
            "Apakah anda merasakan sesak nafas?",
            0,
            "",
            arrayListOf(
                SoalModel.JawabanModel("Tidak", 0),
                SoalModel.JawabanModel("Ya", 0)
            )
        ),
        SoalModel(
            "SR-007",
            "Apakah anda merasakan sakit tenggorokan?",
            0,
            "",
            arrayListOf(
                SoalModel.JawabanModel("Tidak", 0),
                SoalModel.JawabanModel("Ya", 0)
            )
        ),
        SoalModel(
            "SR-008",
            "Apakah anda pilek?",
            0,
            "",
            arrayListOf(
                SoalModel.JawabanModel("Tidak", 0),
                SoalModel.JawabanModel("Ya", 0)
            )
        ),
        SoalModel(
            "SR-009",
            "Apakah anda pernah di diagnosa pneumonia oleh dokter?",
            0,
            "",
            arrayListOf(
                SoalModel.JawabanModel("Tidak", 0),
                SoalModel.JawabanModel("Ya", 0)
            )
        ),
        SoalModel(
            "SR-010",
            "Apakah anda pernah di diagnosa infeksi saluran pernafasan atas / ISPA oleh dokter?",
            0,
            "",
            arrayListOf(
                SoalModel.JawabanModel("Tidak", 0),
                SoalModel.JawabanModel("Ya", 0)
            )
        ),
        SoalModel(
            "SR-011",
            "Apakah saudara pernah melakukan tes COVID-19 metode PCR?",
            0,
            "",
            arrayListOf(
                SoalModel.JawabanModel("Tidak", 0),
                SoalModel.JawabanModel("Ya", 0)
            )
        ),
        SoalModel(
            "GHQ-001",
            "Saya mampu berkonsentrasi",
            1,
            "",
            arrayListOf(
                SoalModel.JawabanModel("Selalu", 0),
                SoalModel.JawabanModel("Sering", 1),
                SoalModel.JawabanModel("Jarang", 3),
                SoalModel.JawabanModel("Tidak Pernah", 2)
            )
        ),
        SoalModel(
            "GHQ-002",
            "Saya kehilangan waktu tidur karena merasa khawatir",
            1,
            "",
            arrayListOf(
                SoalModel.JawabanModel("Selalu", 3),
                SoalModel.JawabanModel("Sering", 2),
                SoalModel.JawabanModel("Jarang", 1),
                SoalModel.JawabanModel("Tidak Pernah", 0)
            )
        ),
        SoalModel(
            "GHQ-003",
            "Saya memiliki peran yang bermanfaat bagi orang lain",
            1,
            "",
            arrayListOf(
                SoalModel.JawabanModel("Selalu", 0),
                SoalModel.JawabanModel("Sering", 1),
                SoalModel.JawabanModel("Jarang", 2),
                SoalModel.JawabanModel("Tidak Pernah", 3)
            )
        ),
        SoalModel(
            "GHQ-004",
            "Saya mampu membuat keputusan",
            1,
            "",
            arrayListOf(
                SoalModel.JawabanModel("Selalu", 0),
                SoalModel.JawabanModel("Sering", 1),
                SoalModel.JawabanModel("Jarang", 2),
                SoalModel.JawabanModel("Tidak Pernah", 3)
            )
        ),
        SoalModel(
            "GHQ-005",
            "Saya merasa terus – menerus berada dibawah tekanan",
            1,
            "",
            arrayListOf(
                SoalModel.JawabanModel("Selalu", 3),
                SoalModel.JawabanModel("Sering", 2),
                SoalModel.JawabanModel("Jarang", 1),
                SoalModel.JawabanModel("Tidak Pernah", 0)
            )
        ),
        SoalModel(
            "GHQ-006",
            "Saya tidak dapat mengatasi kesulitan",
            1,
            "",
            arrayListOf(
                SoalModel.JawabanModel("Selalu", 3),
                SoalModel.JawabanModel("Sering", 2),
                SoalModel.JawabanModel("Jarang", 1),
                SoalModel.JawabanModel("Tidak Pernah", 0)
            )
        ),
        SoalModel(
            "GHQ-007",
            "Saya menikmati kegiatan saya sehari – hari",
            1,
            "",
            arrayListOf(
                SoalModel.JawabanModel("Selalu", 0),
                SoalModel.JawabanModel("Sering", 1),
                SoalModel.JawabanModel("Jarang", 2),
                SoalModel.JawabanModel("Tidak Pernah", 3)
            )
        ),
        SoalModel(
            "GHQ-008",
            "Saya mampu menghadapi masalah",
            1,
            "",
            arrayListOf(
                SoalModel.JawabanModel("Selalu", 0),
                SoalModel.JawabanModel("Sering", 1),
                SoalModel.JawabanModel("Jarang", 2),
                SoalModel.JawabanModel("Tidak Pernah", 3)
            )
        ),
        SoalModel(
            "GHQ-009",
            "Saya merasa tidak bahagia dan tertekan",
            1,
            "",
            arrayListOf(
                SoalModel.JawabanModel("Selalu", 3),
                SoalModel.JawabanModel("Sering", 2),
                SoalModel.JawabanModel("Jarang", 1),
                SoalModel.JawabanModel("Tidak Pernah", 0)
            )
        ),
        SoalModel(
            "GHQ-010",
            "Saya kehilangan kepercayaan diri",
            1,
            "",
            arrayListOf(
                SoalModel.JawabanModel("Selalu", 3),
                SoalModel.JawabanModel("Sering", 2),
                SoalModel.JawabanModel("Jarang", 1),
                SoalModel.JawabanModel("Tidak Pernah", 0)
            )
        ),
        SoalModel(
            "GHQ-011",
            "Saya berpikir bahwa saya tidak berharga",
            1,
            "",
            arrayListOf(
                SoalModel.JawabanModel("Selalu", 3),
                SoalModel.JawabanModel("Sering", 2),
                SoalModel.JawabanModel("Jarang", 1),
                SoalModel.JawabanModel("Tidak Pernah", 0)
            )
        ),
        SoalModel(
            "GHQ-012",
            "Saya merasa saya cukup bahagia",
            1,
            "",
            arrayListOf(
                SoalModel.JawabanModel("Selalu", 0),
                SoalModel.JawabanModel("Sering", 1),
                SoalModel.JawabanModel("Jarang", 2),
                SoalModel.JawabanModel("Tidak Pernah", 3)
            )
        ),
        SoalModel(
            "GAD-001",
            "Merasa cemas, gelisah atau amat tegang",
            2,
            "",
            arrayListOf(
                SoalModel.JawabanModel(
                    "Tidak Pernah",
                    0
                ),
                SoalModel.JawabanModel(
                    "Beberapa Hari",
                    1
                ),
                SoalModel.JawabanModel(
                    "Lebih dari seminggu",
                    2
                ),
                SoalModel.JawabanModel(
                    "Hampir setiap hari",
                    3
                )
            )
        ),
        SoalModel(
            "GAD-002",
            "Tidak mampu menghentikan atau mengendalikan rasa khawatir",
            2,
            "",
            arrayListOf(
                SoalModel.JawabanModel(
                    "Tidak Pernah",
                    0
                ),
                SoalModel.JawabanModel(
                    "Beberapa Hari",
                    1
                ),
                SoalModel.JawabanModel(
                    "Lebih dari seminggu",
                    2
                ),
                SoalModel.JawabanModel(
                    "Hampir setiap hari",
                    3
                )
            )
        ),
        SoalModel(
            "GAD-003",
            "Terlalu mengkhawatirkan berbagai hal",
            2,
            "",
            arrayListOf(
                SoalModel.JawabanModel(
                    "Tidak Pernah",
                    0
                ),
                SoalModel.JawabanModel(
                    "Beberapa Hari",
                    1
                ),
                SoalModel.JawabanModel(
                    "Lebih dari seminggu",
                    2
                ),
                SoalModel.JawabanModel(
                    "Hampir setiap hari",
                    3
                )
            )
        ),
        SoalModel(
            "GAD-004",
            "Sulit untuk santai",
            2,
            "",
            arrayListOf(
                SoalModel.JawabanModel(
                    "Tidak Pernah",
                    0
                ),
                SoalModel.JawabanModel(
                    "Beberapa Hari",
                    1
                ),
                SoalModel.JawabanModel(
                    "Lebih dari seminggu",
                    2
                ),
                SoalModel.JawabanModel(
                    "Hampir setiap hari",
                    3
                )
            )
        ),
        SoalModel(
            "GAD-005",
            "Sangat gelisah sehingga sulit untuk duduk diam",
            2,
            "",
            arrayListOf(
                SoalModel.JawabanModel(
                    "Tidak Pernah",
                    0
                ),
                SoalModel.JawabanModel(
                    "Beberapa Hari",
                    1
                ),
                SoalModel.JawabanModel(
                    "Lebih dari seminggu",
                    2
                ),
                SoalModel.JawabanModel(
                    "Hampir setiap hari",
                    3
                )
            )
        ),
        SoalModel(
            "GAD-006",
            "Menjadi mudah jengkel atau lekas marah",
            2,
            "",
            arrayListOf(
                SoalModel.JawabanModel(
                    "Tidak Pernah",
                    0
                ),
                SoalModel.JawabanModel(
                    "Beberapa Hari",
                    1
                ),
                SoalModel.JawabanModel(
                    "Lebih dari seminggu",
                    2
                ),
                SoalModel.JawabanModel(
                    "Hampir setiap hari",
                    3
                )
            )
        ),
        SoalModel(
            "GAD-007",
            "Merasa takut seoleh – olah sesuatu yang mengerikan mungkin terjadi",
            2,
            "",
            arrayListOf(
                SoalModel.JawabanModel(
                    "Tidak Pernah",
                    0
                ),
                SoalModel.JawabanModel(
                    "Beberapa Hari",
                    1
                ),
                SoalModel.JawabanModel(
                    "Lebih dari seminggu",
                    2
                ),
                SoalModel.JawabanModel(
                    "Hampir setiap hari",
                    3
                )
            )
        ),
        SoalModel(
            "PHQ-001",
            "Kurang tertarik atau bergairah dalam melakukan apapun",
            3,
            "",
            arrayListOf(
                SoalModel.JawabanModel(
                    "Tidak Pernah",
                    0
                ),
                SoalModel.JawabanModel(
                    "Beberapa Hari",
                    1
                ),
                SoalModel.JawabanModel(
                    "Lebih dari seminggu",
                    2
                ),
                SoalModel.JawabanModel(
                    "Hampir setiap hari",
                    3
                )
            )
        ),
        SoalModel(
            "PHQ-002",
            "Merasa murung, muram atau putus asa",
            3,
            "",
            arrayListOf(
                SoalModel.JawabanModel(
                    "Tidak Pernah",
                    0
                ),
                SoalModel.JawabanModel(
                    "Beberapa Hari",
                    1
                ),
                SoalModel.JawabanModel(
                    "Lebih dari seminggu",
                    2
                ),
                SoalModel.JawabanModel(
                    "Hampir setiap hari",
                    3
                )
            )
        ),
        SoalModel(
            "PHQ-003",
            "Sulit tidur atau mudah terbangun, atau terlalu banyak tidur",
            3,
            "",
            arrayListOf(
                SoalModel.JawabanModel(
                    "Tidak Pernah",
                    0
                ),
                SoalModel.JawabanModel(
                    "Beberapa Hari",
                    1
                ),
                SoalModel.JawabanModel(
                    "Lebih dari seminggu",
                    2
                ),
                SoalModel.JawabanModel(
                    "Hampir setiap hari",
                    3
                )
            )
        ),
        SoalModel(
            "PHQ-004",
            "Merasa lelah atau kurang bertenaga",
            3,
            "",
            arrayListOf(
                SoalModel.JawabanModel(
                    "Tidak Pernah",
                    0
                ),
                SoalModel.JawabanModel(
                    "Beberapa Hari",
                    1
                ),
                SoalModel.JawabanModel(
                    "Lebih dari seminggu",
                    2
                ),
                SoalModel.JawabanModel(
                    "Hampir setiap hari",
                    3
                )
            )
        ),
        SoalModel(
            "PHQ-005",
            "Kurang nafsu makan atau terlalu banyak makan",
            3,
            "",
            arrayListOf(
                SoalModel.JawabanModel(
                    "Tidak Pernah",
                    0
                ),
                SoalModel.JawabanModel(
                    "Beberapa Hari",
                    1
                ),
                SoalModel.JawabanModel(
                    "Lebih dari seminggu",
                    2
                ),
                SoalModel.JawabanModel(
                    "Hampir setiap hari",
                    3
                )
            )
        ),
        SoalModel(
            "PHQ-006",
            "Kurang percaya diri atau merasa bahwa anda adalah orang yang gagal atau telah mengecewakan diri sendiri atau keluarga",
            3,
            "",
            arrayListOf(
                SoalModel.JawabanModel(
                    "Tidak Pernah",
                    0
                ),
                SoalModel.JawabanModel(
                    "Beberapa Hari",
                    1
                ),
                SoalModel.JawabanModel(
                    "Lebih dari seminggu",
                    2
                ),
                SoalModel.JawabanModel(
                    "Hampir setiap hari",
                    3
                )
            )
        ),
        SoalModel(
            "PHQ-007",
            "Sulit berkonsentrasi pada sesuatu misalnya membaca Koran atau menonton televisi",
            3,
            "",
            arrayListOf(
                SoalModel.JawabanModel(
                    "Tidak Pernah",
                    0
                ),
                SoalModel.JawabanModel(
                    "Beberapa Hari",
                    1
                ),
                SoalModel.JawabanModel(
                    "Lebih dari seminggu",
                    2
                ),
                SoalModel.JawabanModel(
                    "Hampir setiap hari",
                    3
                )
            )
        ),
        SoalModel(
            "PHQ-008",
            "Bergerak atau berbicara sangat lambat sehingga orang lain memperhatikannya. Atau sebaliknya merasa resah atau gelisah sehingga anda lebih sering bergerak dari biasanya",
            3,
            "",
            arrayListOf(
                SoalModel.JawabanModel(
                    "Tidak Pernah",
                    0
                ),
                SoalModel.JawabanModel(
                    "Beberapa Hari",
                    1
                ),
                SoalModel.JawabanModel(
                    "Lebih dari seminggu",
                    2
                ),
                SoalModel.JawabanModel(
                    "Hampir setiap hari",
                    3
                )
            )
        ),
        SoalModel(
            "PHQ-009",
            "Merasa lebih baik mati atau ingin melukai diri sendiri dengan cara apapun",
            3,
            "",
            arrayListOf(
                SoalModel.JawabanModel(
                    "Tidak Pernah",
                    0
                ),
                SoalModel.JawabanModel(
                    "Beberapa Hari",
                    1
                ),
                SoalModel.JawabanModel(
                    "Lebih dari seminggu",
                    2
                ),
                SoalModel.JawabanModel(
                    "Hampir setiap hari",
                    3
                )
            )
        )
    )

    fun getPekerjaan(): List<String> {
        return listOf(
            "ASN",
            "Pegawai Swasta",
            "Pelaut",
            "TKI",
            "Pilot",
            "Pramugari",
            "Pedagang",
            "Mahasiswa/Pelajar",
            "Tenaga Kesehatan"
        )
    }

    fun getTenagaKesehatan(): List<String> {
        return listOf(
            "Perawat",
            "Dokter",
            "Gizi",
            "Farmasi",
            "Bidan",
            "Sanitarian"
        )
    }

    fun getListProvinsi(): List<String> {
        return listOf(
            "Aceh",
            "Bali",
            "Banten",
            "Bengkulu",
            "D.I Yogyakarta",
            "D.K.I Jakarta",
            "Gorontalo",
            "Jambi",
            "Jawa Barat",
            "Jawa Tengah",
            "Jawa Timur",
            "Kalimantan Barat",
            "Kalimantan Selatan",
            "Kalimantan Tengah",
            "Kalimantan Timur",
            "Kalimantan Utara",
            "Kepulauan Bangka Belitung",
            "Kepulauan Riau",
            "Lampung",
            "Maluku",
            "Maluku Utara",
            "Nusa Tenggara Barat",
            "Nusa Tenggara Timur",
            "Papua",
            "Papua Barat",
            "Riau",
            "Sulawesi Barat",
            "Sulawesi Selatan",
            "Sulawesi Tengah",
            "Sulawesi Tenggara",
            "Sulawesi Utara",
            "Sumatera Barat",
            "Sumatera Selatan",
            "Sumatera Utara"
        )
    }

    fun getListKota(s: String): List<String> {
        return when (s) {
            "Aceh" -> listOf(
                "Kabupaten Aceh Barat",
                "Kabupaten Aceh Barat Daya",
                "Kabupaten Aceh Besar",
                "Kabupaten Aceh Jaya",
                "Kabupaten Aceh Selatan",
                "Kabupaten Aceh Singkil",
                "Kabupaten Aceh Tamiang",
                "Kabupaten Aceh Tengah",
                "Kabupaten Aceh Tenggara",
                "Kabupaten Aceh Timur",
                "Kabupaten Aceh Utara",
                "Kabupaten Bener Meriah",
                "Kabupaten Bireuen",
                "Kabupaten Gayo Lues",
                "Kabupaten Nagan Raya",
                "Kabupaten Pidie",
                "Kabupaten Pidie Jaya",
                "Kabupaten Simeulue",
                "Kota Banda Aceh",
                "Kota Langsa",
                "Kota Lhokseumawe",
                "Kota Sabang",
                "Kota Subulussalam"
            )
            "Bali" -> listOf(
                "Kabupaten Badung",
                "Kabupaten Bangil",
                "Kabupaten Buleleng",
                "Kabupaten Gianyar",
                "Kabupaten Jembrana",
                "Kabupaten Karangasem",
                "Kabupaten Klungkung",
                "Kabupaten Tabanan",
                "Kota Denpasar"
            )
            "Banten" -> listOf(
                "Kabupaten Lebak",
                "Kabupaten Pandeglang",
                "Kabupaten Serang",
                "Kabupaten Tangerang",
                "Kota Cilegon",
                "Kota Serang",
                "Kota Tangerang",
                "Kota Tangerang selatan"
            )
            "Bengkulu" -> listOf(
                "Kabupaten Bengkulu Selatan",
                "Kabupaten Bemgkulu Tengah",
                "Kabupaten Bengkulu Utara",
                "Kabupaten Kaur",
                "Kabupaten kapahiang",
                "Kabupaten Lebong",
                "Kabupaten Mukomuko",
                "Kabupaten Rejang Lebong",
                "Kabupaten seluma",
                "Kota Bengkulu"
            )
            "D.I Yogyakarta" -> listOf(
                "Kabupaten Bantul",
                "Kabupaten Gunung kildul",
                "Kabupaten Kulon Progo",
                "Kabupaten Sleman",
                "Kota Yogyakarta"
            )
            "D.K.I Jakarta" -> listOf(
                "Kabupaten Kepulauan Seribu",
                "Kota Jakarta Barat",
                "Kota Jakarta Pusat",
                "Kota Jakarta Selatan",
                "Kota Jakarta Timur",
                "Kota Jakarta Utara"
            )
            "Gorontalo" -> listOf(
                "Kabupaten Boalemo",
                "Kabupaten Bone Bolango",
                "Kabupaten Gorontalo",
                "Kabupaten gorontalo Utara",
                "Kabupaten Pahuwato",
                "Kota Gorontalo"
            )
            "Jambi" -> listOf(
                "Kabupaten Batanghari",
                "Kabupaten Bungo",
                "Kabupaten Kerinci",
                "Kabupaten Merangin",
                "Kabupaten Muaro Jambi",
                "Kabupaten Sarolangun",
                "Kabupaten Tanjung Jabung Barat",
                "Kabupaten Tanjung Jabung Timur",
                "Kabupaten Tebo",
                "Kota Jambi",
                "Kota Sungai Penuh"
            )
            "Jawa Barat" -> listOf(
                "Kabupaten Bandung",
                "Kabupaten Bandung Barat",
                "Kabupaten Bekasi",
                "Kabupaten Bogor",
                "Kabupaten Ciamis",
                "Kabupaten Cianjur",
                "Kabupaten Cirebon",
                "Kabupaten Garut",
                "Kabupaten Indramayu",
                "Kabupaten Karawang",
                "Kabupaten Kuningan",
                "Kabupaten Majalengka",
                "Kabupaten Pangandaran",
                "Kabupaten Purwakarta",
                "Kabupaten Subang",
                "Kabupaten Sukabumi",
                "Kabupaten Sumedang",
                "Kabupaten Tasikmalaya",
                "Kota Bandung",
                "Kota Banjar",
                "Kota Bekasi",
                "Kota Bogor",
                "Kota Cimahi",
                "Kota Cirebon",
                "Kota Depok",
                "Kota Sukabumi",
                "Kota Tasikmalaya"
            )
            "Jawa Tengah" -> listOf(
                "Kabupaten Banjarnegara",
                "Kabupaten Banyumas",
                "Kabupaten Batang",
                "Kabupaten Blora",
                "Kabupaten Boyolali",
                "Kabupaten Brebes",
                "Kabupaten Cilacap",
                "Kabupaten Demak",
                "Kabupaten Grobogan",
                "Kabupaten Jepara",
                "Kabupaten Karanganyar",
                "Kabupaten Kebumen",
                "Kabupaten Kendal",
                "Kabupaten Klaten",
                "Kabupaten Kudus",
                "Kabupaten Magelang",
                "Kabupaten Pati",
                "Kabupaten Pekalongan",
                "Kabupaten Pemalang",
                "Kabupaten Purbalingga",
                "Kabupaten Purworejo",
                "Kabupaten Rembang",
                "Kabupaten Semarang",
                "Kabupaten Sragen",
                "Kabupaten Sukoharjo",
                "Kabupaten Tegal",
                "Kabupaten Temanggung",
                "Kabupaten Wonogiri",
                "Kabupaten Wonosobo",
                "Kota Magelang",
                "Kota Pekalongan",
                "Kota Salatiga",
                "Kota Semarang",
                "Kota Surakarta",
                "Kota Tegal"
            )
            "Jawa Timur" -> listOf(
                "Kabupaten Bangkalan",
                "Kabupaten Banyuwangi",
                "Kabupaten Blitar",
                "Kabupaten Bojonegoro",
                "Kabupaten Bondowoso",
                "Kabupaten Gresik",
                "Kabupaten Jember",
                "Kabupaten Jombang",
                "Kabupaten Kediri",
                "Kabupaten Lamongan",
                "Kabupaten Lumajang",
                "Kabupaten Madiun",
                "Kabupaten Magetan",
                "Kabupaten Malang",
                "Kabupaten Mojokerto",
                "Kabupaten Nganjuk",
                "Kabupaten Ngawi",
                "Kabupaten Pacitan",
                "Kabupaten Pamekasan",
                "Kabupaten Pasuruan",
                "Kabupaten Ponorogo",
                "Kabupaten Probolinggo",
                "Kabupaten Sampang",
                "Kabupaten Sidoarjo",
                "Kabupaten Situbondo",
                "Kabupaten Sumenep",
                "Kabupaten Trenggalek",
                "Kabupaten Tuban",
                "Kabupaten Tulungagung",
                "Kota Batu",
                "Kota Blitar",
                "Kota Kediri",
                "Kota Madiun",
                "Kota Malang",
                "Kota Mojokerto",
                "Kota Pasuruan",
                "Kota Probolinggo",
                "Kota Surabaya"
            )
            "Kalimantan Barat" -> listOf(
                "Kabupaten Bengkayang",
                "Kabupaten Kapuas Hulu",
                "Kabupaten Kayong Utara",
                "Kabupaten Ketapang",
                "Kabupaten Kubu Raya",
                "Kabupaten Landak",
                "Kabupaten Melawi",
                "Kabupaten Pontianak",
                "Kabupaten Sambas",
                "Kabupaten Sanggau",
                "Kabupaten Sekadau",
                "Kabupaten Sintang",
                "Kota Pontianak",
                "Kota Singkawang"
            )
            "Kalimantan Selatan" -> listOf(
                "Kabupaten Balangan",
                "Kabupaten Banjar",
                "Kabupaten Barito Kuala",
                "Kabupaten Hulu Sungai Selatan",
                "Kabupaten Hulu Sungai Tengah",
                "Kabupaten Hulu Sungai Utara",
                "Kabupaten Kotabaru",
                "Kabupaten Tabalong",
                "Kabupaten Tanah Bumbu",
                "Kabupaten Tanah Laut",
                "Kabupaten Tapin",
                "Kota Banjarbaru",
                "Kota Banjarmasin"
            )
            "Kalimantan Tengah" -> listOf(
                "Kabupaten Barito Selatan",
                "Kabupaten Barito Timur",
                "Kabupaten Barito Utara",
                "Kabupaten Gunung Mas",
                "Kabupaten Kapuas",
                "Kabupaten Katingan",
                "Kabupaten Kotawaringin Barat",
                "Kabupaten Kotawaringin Timur",
                "Kabupaten Lamandau",
                "Kabupaten Murung Raya",
                "Kabupaten Pulang Pisau",
                "Kabupaten Sukamara",
                "Kabupaten Seruyan",
                "Kota Palangka Raya"
            )
            "Kalimantan Timur" -> listOf(
                "Kabupaten Berau",
                "Kabupaten Kutai Barat",
                "Kabupaten Kutai Kartanegara",
                "Kabupaten Kutai Timur",
                "Kabupaten Paser",
                "Kabupaten Penajam Paser Utara",
                "Kabupaten Mahakam Ulu",
                "Kota Balikpapan",
                "Kota Bontang",
                "Kota Samarinda"
            )
            "Kalimantan Utara" -> listOf(
                "Kabupaten Bulungan",
                "Kabupaten Malinau",
                "Kabupaten Nunukan",
                "Kabupaten Tana Tidung",
                "Kota Tarakan"
            )
            "Kepulauan Bangka Belitung" -> listOf(
                "Kabupaten Bangka",
                "Kabupaten Bangka Barat",
                "Kabupaten Bangka Selatan",
                "Kabupaten Bangka Tengah",
                "Kabupaten Belitung",
                "Kabupaten Belitung Timur",
                "Kota Pangkal Pinang"
            )
            "Kepulauan Riau" -> listOf(
                "Kabupaten Bintan",
                "Kabupaten Karimun",
                "Kabupaten Kepulauan Anambas",
                "Kabupaten Lingga",
                "Kabupaten Natuna",
                "Kota Batam",
                "Kota Tanjung Pinang"
            )
            "Lampung" -> listOf(
                "Kabupaten Lampung Barat",
                "Kabupaten Lampung Selatan",
                "Kabupaten Lampung Tengah",
                "Kabupaten Lampung Timur",
                "Kabupaten Lampung Utara",
                "Kabupaten Mesuji",
                "Kabupaten Pesawaran",
                "Kabupaten Pringsewu",
                "Kabupaten Tanggamus",
                "Kabupaten Tulang Bawang",
                "Kabupaten Tulang Bawang Barat",
                "Kabupaten Way Kanan",
                "Kabupaten Pesisir Barat",
                "Kota Bandar Lampung",
                "Kota Kotabumi",
                "Kota Liwa",
                "Kota Metro"
            )
            "Maluku" -> listOf(
                "Kabupaten Buru",
                "Kabupaten Buru Selatan",
                "Kabupaten Kepulauan Aru",
                "Kabupaten Maluku Barat Daya",
                "Kabupaten Maluku Tengah",
                "Kabupaten Maluku Tenggara",
                "Kabupaten Maluku Tenggara Barat",
                "Kabupaten Seram Bagian Barat",
                "Kabupaten Seram Bagian Timur",
                "Kota Ambon",
                "Kota Tual"
            )
            "Maluku Utara" -> listOf(
                "Kabupaten Halmahera Barat",
                "Kabupaten Halmahera Tengah",
                "Kabupaten Halmahera Utara",
                "Kabupaten Halmahera Selatan",
                "Kabupaten Halmahera Timur",
                "Kabupaten Kepulauan Sula",
                "Kabupaten Pulau Morotai",
                "Kabupaten Pulau Taliabu",
                "Kota Ternate",
                "Kota Tidore Kepulauan"
            )
            "Nusa Tenggara Barat" -> listOf(
                "Kabupaten Bima",
                "Kabupaten Dompu",
                "Kabupaten Lombok Barat",
                "Kabupaten Lombok Tengah",
                "Kabupaten Lombok Timur",
                "Kabupaten Lombok Utara",
                "Kabupaten Sumbawa",
                "Kabupaten Sumbawa Barat",
                "Kota Bima",
                "Kota Mataram"
            )
            "Nusa Tenggara Timur" -> listOf(
                "Kabupaten Alor",
                "Kabupaten Belu",
                "Kabupaten Ende",
                "Kabupaten Flores Timur",
                "Kabupaten Kupang",
                "Kabupaten Lembata",
                "Kabupaten Manggarai",
                "Kabupaten Manggarai Barat",
                "Kabupaten Manggarai Timur",
                "Kabupaten Ngada",
                "Kabupaten Nagekeo",
                "Kabupaten Rote Ndao",
                "Kabupaten Sabu Raijua",
                "Kabupaten Sikka",
                "Kabupaten Sumba Barat",
                "Kabupaten Sumba Barat Daya",
                "Kabupaten Sumba Tengah",
                "Kabupaten Sumba Timur",
                "Kabupaten Timor Tengah Selatan",
                "Kabupaten Timor Tengah Utara",
                "Kota Kupang"
            )
            "Papua" -> listOf(
                "Kabupaten Asmat",
                "Kabupaten Biak Numfor",
                "Kabupaten Boven Digoel",
                "Kabupaten Deiyai",
                "Kabupaten Dogiyai",
                "Kabupaten Intan Jaya",
                "Kabupaten Jayapura",
                "Kabupaten Jayawijaya",
                "Kabupaten Keerom",
                "Kabupaten Kepulauan Yapen",
                "Kabupaten Lanny Jaya",
                "Kabupaten Mamberamo Raya",
                "Kabupaten Mamberamo Tengah",
                "Kabupaten Mappi",
                "Kabupaten Merauke",
                "Kabupaten Mimika",
                "Kabupaten Nabire",
                "Kabupaten Nduga",
                "Kabupaten Paniai",
                "Kabupaten Pegunungan Bintang",
                "Kabupaten Puncak",
                "Kabupaten Puncak Jaya",
                "Kabupaten Sarmi",
                "Kabupaten Supiori",
                "Kabupaten Tolikara",
                "Kabupaten Waropen",
                "Kabupaten Yahukimo",
                "Kabupaten Yalimo",
                "Kota Jayapura"
            )
            "Papua Barat" -> listOf(
                "Kabupaten Fakfak",
                "Kabupaten Kaimana",
                "Kabupaten Manokwari",
                "Kabupaten Manokwari Selatan",
                "Kabupaten Maybrat",
                "Kabupaten Pegunungan Arfak",
                "Kabupaten Raja Ampat",
                "Kabupaten Sorong",
                "Kabupaten Sorong Selatan",
                "Kabupaten Tambrauw",
                "Kabupaten Teluk Bintuni",
                "Kabupaten Teluk Wondama",
                "Kota Sorong"
            )
            "Riau" -> listOf(
                "Kabupaten Bengkalis",
                "Kabupaten Indragiri Hilir",
                "Kabupaten Indragiri Hulu",
                "Kabupaten Kampar",
                "Kabupaten Kuantan Singingi",
                "Kabupaten Pelalawan",
                "Kabupaten Rokan Hilir",
                "Kabupaten Rokan Hulu",
                "Kabupaten Siak",
                "Kabupaten Kepulauan Meranti",
                "Kota Dumai",
                "Kota Pekanbaru"
            )
            "Sulawesi Barat" -> listOf(
                "Kabupaten Majene",
                "Kabupaten Mamasa",
                "Kabupaten Mamuju",
                "Kabupaten Mamuju Utara",
                "Kabupaten Polewali Mandar",
                "Kabupaten Mamuju Tengah"
            )
            "Sulawesi Selatan" -> listOf(
                "Kabupaten Bantaeng",
                "Kabupaten Barru",
                "Kabupaten Bone	Watampone",
                "Kabupaten Bulukumba",
                "Kabupaten Enrekang",
                "Kabupaten Gowa",
                "Kabupaten Jeneponto",
                "Kabupaten Kepulauan Selayar",
                "Kabupaten Luwu",
                "Kabupaten Luwu Timur",
                "Kabupaten Luwu Utara",
                "Kabupaten Maros",
                "Kabupaten Pangkajene dan Kepulauan",
                "Kabupaten Pinrang",
                "Kabupaten Sidenreng Rappang",
                "Kabupaten Sinjai",
                "Kabupaten Soppeng",
                "Kabupaten Takalar",
                "Kabupaten Tana Toraja",
                "Kabupaten Toraja Utara",
                "Kabupaten Wajo",
                "Kota Makassar",
                "Kota Palopo",
                "Kota Parepare"
            )
            "Sulawesi Tengah" -> listOf(
                "Kabupaten Banggai",
                "Kabupaten Banggai Kepulauan",
                "Kabupaten Banggai Laut",
                "Kabupaten Buol",
                "Kabupaten Donggala",
                "Kabupaten Morowali",
                "Kabupaten Parigi Moutong",
                "Kabupaten Poso",
                "Kabupaten Sigi",
                "Kabupaten Tojo Una-Una",
                "Kabupaten Tolitoli",
                "Kota Palu"
            )
            "Sulawesi Tenggara" -> listOf(
                "Kabupaten Bombana",
                "Kabupaten Buton",
                "Kabupaten Buton Utara",
                "Kabupaten Kolaka",
                "Kabupaten Kolaka Timur",
                "Kabupaten Kolaka Utara",
                "Kabupaten Konawe",
                "Kabupaten Konawe Selatan",
                "Kabupaten Konawe Utara",
                "Kabupaten Konawe Kepulauan",
                "Kabupaten Muna",
                "Kabupaten Wakatobi",
                "Kota Bau-Bau",
                "Kota Kendari"
            )
            "Sulawesi Utara" -> listOf(
                "Kabupaten Bolaang Mongondow",
                "Kabupaten Bolaang Mongondow Selatan",
                "Kabupaten Bolaang Mongondow Timur",
                "Kabupaten Bolaang Mongondow Utara",
                "Kabupaten Kepulauan Sangihe",
                "Kabupaten Kepulauan Siau Tagulandang Biaro",
                "Kabupaten Kepulauan Talaud",
                "Kabupaten Minahasa",
                "Kabupaten Minahasa Selatan",
                "Kabupaten Minahasa Tenggara",
                "Kabupaten Minahasa Utara",
                "Kota Bitung",
                "Kota Kotamobagu",
                "Kota Manado",
                "Kota Tomohon"
            )
            "Sumatera Barat" -> listOf(
                "Kabupaten Agam",
                "Kabupaten Dharmasraya",
                "Kabupaten Kepulauan Mentawai",
                "Kabupaten Lima Puluh Kota",
                "Kabupaten Padang Pariaman",
                "Kabupaten Pasaman",
                "Kabupaten Pasaman Barat",
                "Kabupaten Pesisir Selatan",
                "Kabupaten Sijunjung",
                "Kabupaten Solok",
                "Kabupaten Solok Selatan",
                "Kabupaten Tanah Datar",
                "Kota Bukittinggi",
                "Kota Padang",
                "Kota Padangpanjang",
                "Kota Pariaman",
                "Kota Payakumbuh",
                "Kota Sawahlunto",
                "Kota Solok"
            )
            "Sumatera Selatan" -> listOf(
                "Kabupaten Banyuasin",
                "Kabupaten Empat Lawang",
                "Kabupaten Lahat",
                "Kabupaten Muara Enim",
                "Kabupaten Musi Banyuasin",
                "Kabupaten Musi Rawas",
                "Kabupaten Ogan Ilir",
                "Kabupaten Ogan Komering Ilir",
                "Kabupaten Ogan Komering Ulu",
                "Kabupaten Ogan Komering Ulu Selatan",
                "Kabupaten Penukal Abab Lematang Ilir",
                "Kabupaten Ogan Komering Ulu Timur",
                "Kota Lubuklinggau",
                "Kota Pagar Alam",
                "Kota Palembang",
                "Kota Prabumulih"
            )
            "Sumatera Utara" -> listOf(
                "Kabupaten Asahan",
                "Kabupaten Batubara",
                "Kabupaten Dairi",
                "Kabupaten Deli Serdang",
                "Kabupaten Humbang Hasundutan",
                "Kabupaten Karo	Kabanjahe",
                "Kabupaten Labuhanbatu",
                "Kabupaten Labuhanbatu Selatan",
                "Kabupaten Labuhanbatu Utara",
                "Kabupaten Langkat",
                "Kabupaten Mandailing Natal",
                "Kabupaten Nias",
                "Kabupaten Nias Barat",
                "Kabupaten Nias Selatan",
                "Kabupaten Nias Utara",
                "Kabupaten Padang Lawas",
                "Kabupaten Padang Lawas Utara",
                "Kabupaten Pakpak Bharat",
                "Kabupaten Samosir",
                "Kabupaten Serdang Bedagai",
                "Kabupaten Simalungun",
                "Kabupaten Tapanuli Selatan",
                "Kabupaten Tapanuli Tengah",
                "Kabupaten Tapanuli Utara",
                "Kabupaten Toba Samosir",
                "Kota Binjai",
                "Kota Gunungsitoli",
                "Kota Medan",
                "Kota Padangsidempuan",
                "Kota Pematangsiantar",
                "Kota Sibolga",
                "Kota Tanjungbalai",
                "Kota Tebing Tinggi"
            )
            else -> listOf()
        }
    }
}