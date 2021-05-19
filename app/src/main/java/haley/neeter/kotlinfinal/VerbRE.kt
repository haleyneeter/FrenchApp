package haley.neeter.kotlinfinal

class VerbRE :FrenchVerb {
    var root:String=""
    var meaning: String=""
    var infinitive:String="" //note an infinitive is the verb unconjugated such as "to go", in French it is just one word

    override fun getFS():String
    {
        return root.plus("s")
    }
    override fun getSS():String
    {
        return root.plus("s")
    }
    override fun getTS():String
    {
        return root
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
fun makeListofRE():ArrayList<VerbRE>
{
    var REList= ArrayList<VerbRE>()
    val fondre=VerbRE()
    fondre.infinitive="fondre"
    fondre.meaning="to melt"
    fondre.root="fond"
    REList.add(fondre)
    val entendre=VerbRE()
    entendre.infinitive="entendre"
    entendre.meaning="to hear"
    entendre.root="entend"
    REList.add(entendre)
    val attendre=VerbRE()
    attendre.infinitive="attendre"
    attendre.meaning="to wait (for)"
    attendre.root="attend"
    REList.add(attendre)
    val vendre=VerbRE()
    vendre.infinitive="vendre"
    vendre.meaning="to sell"
    vendre.root="vend"
    REList.add(vendre)
    val perdre=VerbRE()
    perdre.infinitive="perdre"
    perdre.meaning="to lose"
    perdre.root="perd"
    REList.add(perdre)
    val mordre=VerbRE()
    mordre.infinitive="mordre"
    mordre.meaning="to bite"
    mordre.root="mord"
    REList.add(mordre)
    val rendre=VerbRE()
    rendre.infinitive="rendre"
    rendre.meaning="to return"
    rendre.root="rend"
    REList.add(rendre)
    return REList
}