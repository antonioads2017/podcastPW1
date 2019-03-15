function adicionaAluno(){
    var meuSelect = document.getElementById("select");
    var emailAluno = meuSelect.options[meuSelect.selectedIndex].value;
    if(document.getElementById(emailAluno) == null){
        var onclick = "onclick=\"removerAluno(\'"+emailAluno+"\')\"";
        console.log(onclick);
        listaAlunos.innerHTML += "<li class='collection-item black-text' id='"+emailAluno+"'>"+emailAluno+
                                    "<a class='secondary-content'>"+
                                        "<i "+onclick+" class='material-icons' >"+
                                            "close"+
                                        "</i>"+
                                    "</a>"+
                                 "</li>";
    }

}

function removerAluno(emailAluno) {
    document.getElementById(emailAluno).remove();
}