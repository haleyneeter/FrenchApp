package haley.neeter.kotlinfinal

class VerbIR:FrenchVerb {
    var root:String=""
    var meaning: String=""
    var infinitive:String="" //note an infinitive is the verb unconjugated such as "to go", in French it is just one word

    override fun getFS():String
    {
        return root.plus("is")
    }
    override fun getSS():String
    {
        return root.plus("is")
    }
    override fun getTS():String
    {
        return root.plus("it")
    }
    override fun getFP():String
    {
        return root.plus("issons")
    }
    override fun getSP():String
    {
        return root.plus("issez")
    }
    override fun getTP():String
    {
        return root.plus("issent")
    }

}
fun makeListofIR():ArrayList<VerbIR>
{
    var IRList= ArrayList<VerbIR>()
    val finir:VerbIR= VerbIR()
    finir.infinitive="finir"
    finir.meaning="to finish"
    finir.root="fin"
    IRList.add(finir)
    val rougir=VerbIR()
    rougir.infinitive="rougir"
    rougir.meaning="to blush"
    rougir.root="roug"
    IRList.add(rougir)
    val vieillir=VerbIR()
    vieillir.infinitive="vieillir"
    vieillir.meaning="to age"
    vieillir.root="vieill"
    IRList.add(vieillir)
    val agir=VerbIR()
    agir.infinitive="agir"
    agir.meaning="to act"
    agir.root="ag"
    IRList.add(agir)
    val choisir=VerbIR()
    choisir.infinitive="choisir"
    choisir.meaning="to choose"
    choisir.root="chois"
    IRList.add(choisir)
    val remplir=VerbIR()
    remplir.infinitive="remplir"
    remplir.meaning="to fill"
    remplir.root="rempl"
    IRList.add(remplir)
    val nourrir=VerbIR()
    nourrir.infinitive="nourrir"
    nourrir.meaning="to feed"
    nourrir.root="nourrir"
    IRList.add(nourrir)
    val punir=VerbIR()
    punir.infinitive="punir"
    punir.meaning="to punish"
    punir.root="pun"
    IRList.add(punir)
    return IRList
}