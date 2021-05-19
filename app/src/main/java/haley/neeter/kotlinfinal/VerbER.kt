package haley.neeter.kotlinfinal
class VerbER :FrenchVerb {
    var root:String=""
    var meaning: String=""
    var infinitive:String="" //note an infinitive is the verb unconjugated such as "to go", in French it is just one word

    override fun getFS():String
    {
        return root.plus("e")
    }
    override fun getSS():String
    {
        return root.plus("es")
    }
    override fun getTS():String
    {
        return root.plus("e")
    }
    override fun getFP():String
    {
        return root.plus("ons")
    }
    override fun getSP():String
    {
        return root.plus("ez")
    }
    override fun getTP():String
    {
        return root.plus("ent")
    }

}
fun makeListofER():ArrayList<VerbER>
{
    var ERList= ArrayList<VerbER>()
    val aimer=VerbER()
    aimer.infinitive="aimer"
    aimer.meaning="to like/love"
    aimer.root="aim"
    ERList.add(aimer)
    val chanter=VerbER()
    chanter.infinitive="chanter"
    chanter.meaning="to sing"
    chanter.root="chant"
    ERList.add(chanter)
    val chercher=VerbER()
    chercher.infinitive="chercher"
    chercher.meaning="to look for"
    chercher.root="cherch"
    ERList.add(chercher)
    val donner=VerbER()
    donner.infinitive="donner"
    donner.meaning="to give"
    donner.root="donn"
    ERList.add(donner)
    val fermer=VerbER()
    fermer.infinitive="fermer"
    fermer.meaning="to close"
    fermer.root="ferm"
    ERList.add(fermer)
    val jouer=VerbER()
    jouer.infinitive="jouer"
    jouer.meaning="to play"
    jouer.root="jou"
    ERList.add(jouer)
    val parler=VerbER()
    parler.infinitive="parler"
    parler.meaning="to talk/speak"
    parler.root="parl"
    ERList.add(parler)
    val penser=VerbER()
    penser.infinitive="penser"
    penser.meaning="to think"
    penser.root="pens"
    ERList.add(penser)
    return ERList
}