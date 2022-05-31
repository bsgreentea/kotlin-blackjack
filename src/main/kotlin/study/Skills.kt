package study

class Skills(private val skills: MutableList<Skill> = mutableListOf()) : List<Skill> by skills {
    fun soft(name: String) {
        skills.add(Skill.Soft(name))
    }

    fun hard(name: String) {
        skills.add(Skill.Hard(name))
    }
}
