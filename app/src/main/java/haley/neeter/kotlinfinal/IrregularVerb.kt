package haley.neeter.kotlinfinal

import java.util.*

enum class IrregularVerb (val infinitive:String,val meaning:String, val FS:String, val SS:String, val TS:String,val FP:String, val SP:String, val TP:String) {
    AVOIR("avoir", "to have", "ai", "as", "a", "avons","avez","ont"),
    ALLER("aller", "to go", "vais", "vas", "va", "allons","allez","vont"),
    DIRE("dire", "to say/tell", "dis", "dis", "dit", "disons","dites","disent"),
    SAVOIR("savoir", "to know/ know how to", "sais", "sais", "sait", "savons","savez","savent"),
    VOIR("voir", "to see", "vois", "vois", "voit", "voyons","voyez","voient"),
    VOULOIR("vouloir", "to want to", "veux", "veux", "veut", "voulons","voulez","veulent"),
    MANGER("manger", "to eat", "mange", "manges", "mange", "mangeons","mangez","mangent"),
    ESSAYER("essayer", "to try", "essaie", "essaies", "essaie", "essayons","essayez","essaient"),
    VENIR("venir", "to come", "viens", "viens", "vient", "venons","venez","viennent"),
    FAIRE("faire", "to do/make","fais", "fais", "fait", "faisons", "faites", "font");

}