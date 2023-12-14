enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario (val nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60, val nivel: Nivel)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(vararg usuarios: Usuario) {
        for (usuario in usuarios){
            inscritos.add(usuario)
    }}
}

fun main() {
    val conteudo1 = ConteudoEducacional("Introdução", 120, Nivel.BASICO)
    val conteudo2 = ConteudoEducacional("Algoritimos", 240, Nivel.INTERMEDIARIO)
    val conteudo3 = ConteudoEducacional("Tópicos Avançados", 240, Nivel.DIFICIL)
    val conteudos = listOf(conteudo1, conteudo2, conteudo3)
    
    val formacao = Formacao("Kotlin", conteudos)
    
    val usuario1 = Usuario("João")
    val usuario2 = Usuario("Maria")
    val usuario3 = Usuario("Pedro")
    formacao.matricular(usuario1, usuario2, usuario3)
    
    println("Informações sobre a formação ${formacao.nome}:")
    for (conteudo in formacao.conteudos){
        println(conteudo.toString())
    }
    println()
    println("Inscritos:")
    for (inscrito in formacao.inscritos){
        println(inscrito.nome)
    }
    
}