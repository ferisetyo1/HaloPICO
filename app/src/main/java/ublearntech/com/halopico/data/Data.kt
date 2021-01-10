package ublearntech.com.halopico.data

import ublearntech.com.halopico.R
import ublearntech.com.halopico.model.PakarModel
import ublearntech.com.halopico.model.SoalModel

object Data {

    fun ytKondisigetid(s: String): String {
        return when (s) {
            "Tidak ada perubahan" -> "HG7hvxEe4T4"
            "Risiko gangguan psikologis" -> "BEq9AUEM_tE"
            "Perubahan kondisi psikologis" -> "U0DMlK_xiZI"
            "Khawatir" -> "fbDJ8PpwWyA"
            "Sedih" -> "ZyvQGpHHJ0c"
            else -> ""
        }
    }

    fun kondisifotoUrl(s: String): Int {
        return when (s) {
            "Tidak ada perubahan" -> R.drawable.kondisi1
            "Risiko gangguan psikologis" -> R.drawable.kondisi2
            "Perubahan kondisi psikologis" -> R.drawable.kondisi3
            "Khawatir" -> R.drawable.kondisi4
            "Sedih" -> R.drawable.kondisi5
            else -> 0
        }
    }

    fun getIlustrasi(s: String): Int {
        return when (s) {
            "Tidak ada perubahan" -> R.drawable.tidak_ada
//            "Risiko gangguan psikologis" -> R.drawable.kondisi2
//            "Perubahan kondisi psikologis" -> R.drawable.kondisi3
            "Khawatir" -> R.drawable.khawatir
            "Sedih" -> R.drawable.sedih
            else -> R.drawable.belum
        }
    }

    fun getDataPakar() = arrayListOf(
        PakarModel(
            "Dr. Heni Dwi Windarwati, M. Kep., Sp. Kep.J.",
            "Dinkes Jawa Timur",
            "082232641330",
            ""
        ),
        PakarModel(
            "Ns. Eko Ariek Susmiatin, M. Kep., Sp. Kep.J",
            "Dinkes Jawa Timur",
            "082231557625",
            ""
        ),
        PakarModel(
            "Ns. Komarudin, M. Kep., Sp. KepJ",
            "Dinkes Jawa Timur",
            "0895366793114",
            ""
        ),
        PakarModel(
            "Ns, Rany agustin W, S. Kep. M.Kep",
            "Bondowoso, Jawa Timur",
            "085230382900",
            ""
        ),
        PakarModel(
            "Adelheid Riswanti Herminsih, S.Kep.Ns., M.Kep",
            "Maumare, NTT",
            "082147993658",
            ""
        ),
        PakarModel(
            "Yuldensia Avelina, S.Kep.Ns., M.Kep",
            "Maumere, NTT ",
            "081233695883",
            ""
        ),
        PakarModel(
            "Ns. Destianti Indah Mayasari, M.Kep",
            "Cilacap, Jawa Tengah",
            "085291095210",
            ""
        ),
        PakarModel(
            "Fepyani Thresna Feoh, S.Kep.Ns.M.Kep",
            "Kupang, NTT ",
            "085333650646",
            ""
        ),
        PakarModel(
            "Dwi yogyo Suswinarto. S.Kep. Ns. M.Kep",
            "Palu, Sulawesi Tengah",
            "081243749868",
            ""
        ),
        PakarModel(
            "Widya Lita Fitrianur, S.Kep.Ns.M.Kep",
            "Gresik, Jawa Timur",
            "081336585077",
            ""
        ),
        PakarModel(
            "Yanti Rosdiana, S.Kep.Ns.M.Kep",
            "Malang, Jawa Timur",
            "081249554004",
            ""
        ),
        PakarModel(
            "Gardha Rias Arsy, S.Kep., Ns., M.Kep",
            "Kudus, Jawa Timur",
            "085712771227",
            ""
        ),
        PakarModel(
            "Aisyah Dzil Kamalah S.kep, Ns., M.Kep",
            "Pekalongan, Jawa Tengah",
            "08156968112",
            ""
        ),
        PakarModel(
            "Awaliyah M Suwetty.S.kep, Ns., M.Kep",
            "Kupang, NTT",
            "085239026776",
            ""
        ),
        PakarModel(
            "Ns. Faizatur rohmi, M. Kep",
            "Malang, Jawa Timur",
            "085236743093",
            ""
        ),
        PakarModel(
            "NS. Dhita Kurnia Sari, M. Kep",
            "Kediri, Jawa Timur",
            "082231216464",
            ""
        ),
        PakarModel(
            "Ns,Fransiska Erna Damayanti,M.Kep",
            "Banyuwangi , Jawa Timur",
            "085729588725",
            ""
        ),
        PakarModel(
            "Wenny Nugrahati Carsita, S.Kep.,Ns.,M.Kep",
            "Indramayu Jawa Barat",
            "085222179916",
            ""
        ),
        PakarModel(
            "Helena Pangaribuan, S.kep.Ns.M.Kep",
            "Palu",
            "081342779588",
            ""
        ),
        PakarModel(
            "Ns. Natar Fitri Napitupulu,  M. Kep.",
            "Padangsidimpuan",
            "081225171988",
            ""
        ),
        PakarModel(
            "NSirli Mardianna Trishinta, S.Kep.,Ns.,M.Kep",
            "Malang",
            "081615630041",
            ""
        ),
        PakarModel(
            "Maryati A. Barimbing, S.Kep., Ns., M.Kep",
            "Kupang, NTT.",
            "085339276311",
            ""
        ),
        PakarModel(
            "Miftakhul Ulfa, S.Kep.Ners.M.Kep",
            "Malang ",
            "085646561160",
            ""
        ),
        PakarModel(
            "Reni Nurhidayah, Ns.,M.Kep",
            "Kediri",
            "085736406427",
            ""
        ),
        PakarModel(
            "Kurnia Laksana, S.Kep. Ns.  M.Kep",
            "MALANG ",
            "081232187446",
            ""
        ),
        PakarModel(
            "Ariani Sulistyorini, S.Pd.,M.Kep",
            "Kediri",
            "08123412247",
            ""
        ),
        PakarModel(
            "Iva Milia Hani Rahmawati, S.Kep.,Ns. M.Kep",
            "Jombang",
            "081554717515",
            ""
        ),
        PakarModel(
            "Indari, S.Kep.,Ners.M.Kep",
            "Malang",
            "081334392582",
            ""
        ),
        PakarModel(
            "Ns. Indah Mukarromah, S.Kep., M.Kep.",
            "Jombang  ",
            "085730750019",
            ""
        ),
        PakarModel(
            "Bambang Wiseno, M.Kep",
            "Kediri",
            "081221460327",
            ""
        ),
        PakarModel(
            "Zulian Effendi, S.Kep., NS., M.Kep",
            "Palembang ",
            "081373331158",
            ""
        ),
        PakarModel(
            "Betie Febriana, S.Kep., NS., M.Kep ",
            "Semarang",
            "081314774618",
            ""
        ),
        PakarModel(
            "Lilik Setiawan, S.Kep.Ns.,M.Kep",
            "Kediri",
            "085604817881",
            ""
        ),
        PakarModel(
            "Primasari Mahardhika Rahmawati, S.Kep., Ns., M.Kep.",
            "Lumajang ",
            "082231205554",
            ""
        ),
        PakarModel(
            "Nurul mawaddah, S. Kep., Ns. M. Kep.",
            "Mojokerto",
            "081359524065",
            ""
        ),
        PakarModel(
            "Ns. Yeni Fitria, M.Kep.",
            "Jember ",
            "085733474485",
            ""
        ),
        PakarModel(
            "Ns. Evy Aristawati, S.Kep., M.Kep",
            "Pasuruan",
            "085733684721",
            ""
        ),
        PakarModel(
            "Ns. Abdul Rokhman, M.Kep. ",
            "Lamongan ",
            "085655090492",
            ""
        ),
        PakarModel(
            "Muhammad Rosyidul 'Ibad, S.Kep.,Ns.,M.Kep ",
            "Malang  ",
            "085790819817",
            ""
        )
    )

    fun getDataSoalString() = arrayListOf(
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
            "SR-012",
            "Bagaimana hasil tes saudara?",
            0,
            "",
            arrayListOf(
                SoalModel.JawabanModel("Positif", 0),
                SoalModel.JawabanModel("Negatif", 0)
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
        ),
        SoalModel(
            "SRQ-001",
            "Apakah Anda sering menderita sakit kepala?",
            4,
            "",
            arrayListOf(
                SoalModel.JawabanModel("Tidak",0),
                SoalModel.JawabanModel("Ya",0)
            )
        ),
        SoalModel(
            "SRQ-002",
            "Apakah Anda kehilangan nafsu makan?",
            4,
            "",
            arrayListOf(
                SoalModel.JawabanModel("Tidak",0),
                SoalModel.JawabanModel("Ya",0)
            )
        ),
        SoalModel(
            "SRQ-003",
            "Apakah tidur Anda tidak lelap?",
            4,
            "",
            arrayListOf(
                SoalModel.JawabanModel("Tidak",0),
                SoalModel.JawabanModel("Ya",0)
            )
        ),
        SoalModel(
            "SRQ-004",
            "Apakah Anda mudah menjadi takut?",
            4,
            "",
            arrayListOf(
                SoalModel.JawabanModel("Tidak",0),
                SoalModel.JawabanModel("Ya",0)
            )
        ),
        SoalModel(
            "SRQ-005",
            "Apakah Anda merasa cemas, tegang dan khawatir?",
            4,
            "",
            arrayListOf(
                SoalModel.JawabanModel("Tidak",0),
                SoalModel.JawabanModel("Ya",0)
            )
        ),
        SoalModel(
            "SRQ-006",
            "Apakah tangan Anda gemetar?",
            4,
            "",
            arrayListOf(
                SoalModel.JawabanModel("Tidak",0),
                SoalModel.JawabanModel("Ya",0)
            )
        ),
        SoalModel(
            "SRQ-007",
            "Apakah Anda mengalami gangguan pencernaan?",
            4,
            "",
            arrayListOf(
                SoalModel.JawabanModel("Tidak",0),
                SoalModel.JawabanModel("Ya",0)
            )
        ),
        SoalModel(
            "SRQ-008",
            "Apakah Anda merasa sulit berpikir jernih?",
            4,
            "",
            arrayListOf(
                SoalModel.JawabanModel("Tidak",0),
                SoalModel.JawabanModel("Ya",0)
            )
        ),
        SoalModel(
            "SRQ-009",
            "Apakah Anda merasa tidak bahagia?",
            4,
            "",
            arrayListOf(
                SoalModel.JawabanModel("Tidak",0),
                SoalModel.JawabanModel("Ya",0)
            )
        ),
        SoalModel(
            "SRQ-010",
            "Apakah Anda lebih sering menangis?",
            4,
            "",
            arrayListOf(
                SoalModel.JawabanModel("Tidak",0),
                SoalModel.JawabanModel("Ya",0)
            )
        ),
        SoalModel(
            "SRQ-011",
            "Apakah Anda merasa sulit untuk menikmati aktivitas sehari-hari?",
            4,
            "",
            arrayListOf(
                SoalModel.JawabanModel("Tidak",0),
                SoalModel.JawabanModel("Ya",0)
            )
        ),
        SoalModel(
            "SRQ-012",
            "Apakah Anda mengalami kesulitan untuk mengambil keputusan?",
            4,
            "",
            arrayListOf(
                SoalModel.JawabanModel("Tidak",0),
                SoalModel.JawabanModel("Ya",0)
            )
        ),
        SoalModel(
            "SRQ-013",
            "Apakah aktivitas/tugas sehari-hari Anda terbengkalai?",
            4,
            "",
            arrayListOf(
                SoalModel.JawabanModel("Tidak",0),
                SoalModel.JawabanModel("Ya",0)
            )
        ),
        SoalModel(
            "SRQ-014",
            "Apakah Anda merasa tidak mampu berperan dalam kehidupan ini?",
            4,
            "",
            arrayListOf(
                SoalModel.JawabanModel("Tidak",0),
                SoalModel.JawabanModel("Ya",0)
            )
        ),
        SoalModel(
            "SRQ-015",
            "Apakah Anda kehilangan minat terhadap banyak hal?",
            4,
            "",
            arrayListOf(
                SoalModel.JawabanModel("Tidak",0),
                SoalModel.JawabanModel("Ya",0)
            )
        ),
        SoalModel(
            "SRQ-016",
            "Apakah Anda merasa tidak berharga?",
            4,
            "",
            arrayListOf(
                SoalModel.JawabanModel("Tidak",0),
                SoalModel.JawabanModel("Ya",0)
            )
        ),
        SoalModel(
            "SRQ-017",
            "Apakah Anda mempunyai pikiran untuk mengakhiri hidup Anda?",
            4,
            "",
            arrayListOf(
                SoalModel.JawabanModel("Tidak",0),
                SoalModel.JawabanModel("Ya",0)
            )
        ),
        SoalModel(
            "SRQ-018",
            "Apakah Anda merasa lelah sepanjang waktu?",
            4,
            "",
            arrayListOf(
                SoalModel.JawabanModel("Tidak",0),
                SoalModel.JawabanModel("Ya",0)
            )
        ),
        SoalModel(
            "SRQ-019",
            "Apakah Anda merasa tidak enak di perut?",
            4,
            "",
            arrayListOf(
                SoalModel.JawabanModel("Tidak",0),
                SoalModel.JawabanModel("Ya",0)
            )
        ),
        SoalModel(
            "SRQ-020",
            "Apakah Anda mudah lelah?",
            4,
            "",
            arrayListOf(
                SoalModel.JawabanModel("Tidak",0),
                SoalModel.JawabanModel("Ya",0)
            )
        ),
        SoalModel(
            "SRQ-021",
            "Apakah Anda minum alkohol lebih banyak dari biasanya atau Apakah Anda menggunakan narkoba?",
            4,
            "",
            arrayListOf(
                SoalModel.JawabanModel("Tidak",0),
                SoalModel.JawabanModel("Ya",0)
            )
        ),
        SoalModel(
            "SRQ-022",
            "Apakah Anda yakin bahwa seseorang mencoba mencelakai Anda dengan cara tertentu?",
            4,
            "",
            arrayListOf(
                SoalModel.JawabanModel("Tidak",0),
                SoalModel.JawabanModel("Ya",0)
            )
        ),
        SoalModel(
            "SRQ-023",
            "Apakah ada yang mengganggu atau hal yang tidak biasa dalam pikiran Anda?",
            4,
            "",
            arrayListOf(
                SoalModel.JawabanModel("Tidak",0),
                SoalModel.JawabanModel("Ya",0)
            )
        ),
        SoalModel(
            "SRQ-024",
            "Apakah Anda pernah mendengar suara tanpa tahu sumbernya atau yang orang lain tidak dapat mendengar?",
            4,
            "",
            arrayListOf(
                SoalModel.JawabanModel("Tidak",0),
                SoalModel.JawabanModel("Ya",0)
            )
        ),
        SoalModel(
            "SRQ-025",
            "Apakah Anda mengalami mimpi yang mengganggu tentang suatu bencana/musibah atau adakah saat-saat Anda seolah mengalami kembali kejadian bencana itu? ",
            4,
            "",
            arrayListOf(
                SoalModel.JawabanModel("Tidak",0),
                SoalModel.JawabanModel("Ya",0)
            )
        ),
        SoalModel(
            "SRQ-026",
            "Apakah Anda menghindari kegiatan, tempat, orang atau pikiran yang mengingatkan Anda akan bencana tersebut?",
            4,
            "",
            arrayListOf(
                SoalModel.JawabanModel("Tidak",0),
                SoalModel.JawabanModel("Ya",0)
            )
        ),
        SoalModel(
            "SRQ-027",
            "Apakah minat Anda terhadap teman dan kegiatan yang biasa Anda lakukan berkurang?",
            4,
            "",
            arrayListOf(
                SoalModel.JawabanModel("Tidak",0),
                SoalModel.JawabanModel("Ya",0)
            )
        ),
        SoalModel(
            "SRQ-028",
            "Apakah Anda merasa sangat terganggu jika berada dalam situasi yang mengingatkan Anda akan bencana atau jika Anda berpikir tentang bencana itu?",
            4,
            "",
            arrayListOf(
                SoalModel.JawabanModel("Tidak",0),
                SoalModel.JawabanModel("Ya",0)
            )
        ),
        SoalModel(
            "SRQ-029",
            "Apakah Anda kesulitan memahami atau mengekspresikan perasaan Anda?",
            4,
            "",
            arrayListOf(
                SoalModel.JawabanModel("Tidak",0),
                SoalModel.JawabanModel("Ya",0)
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