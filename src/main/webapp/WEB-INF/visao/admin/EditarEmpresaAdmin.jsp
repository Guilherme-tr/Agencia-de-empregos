<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <meta name="author" content="Lucas Ceoni, Emanoela Simão, Vitor Pastore, João Araújo e Souza"/>
        <meta name="description" content="Aula PW3 - Trabalho final"/>
        <meta name="keywords" content="aula, web, java, mvc, servlet, ifsp, ads"/>
        <meta name="date" content="27/01/2021"/>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
              integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <title>Editar Empresa</title>
    </head>

    <body>
        <div class="container">
            <h1>Edite uma empresa</h1>
            <form method="POST" action="atualizar-empresa">
                <div class="row">
                    <div class="col">
                        <div class="form-group">
                            <label class="form-check-label" for="codigo">Código</label>
                            <input class="form-control" id="codigo" value="${empresa.codigo}" type="text"  name="codigo" readonly/>
                        </div>
                    
                        <div class="form-group">
                            <label class="form-check-label" for="nome">Nome</label>
                            <input class="form-control" id="nome" value="${empresa.nome}" type="text"  name="nome" />
                        </div>
                    </div>
                    <div class="col">
                        <div class="form-group">
                            <label class="form-check-label" for="login">Login</label>
                            <input class="form-control" id="login" value="${empresa.login}" type="text"  name="login"  />
                        </div>
                    
                        <div class="form-group">
                            <label class="form-check-label" for="senha">Senha</label>
                            <input class="form-control" id="senha" value="${empresa.senha}" type="password"  name="senha" />
                        </div>
                    </div>
                </div>
                
                <input type="submit" class="btn btn-primary" name="acao" value="Atualizar">
            </form>
        </div>
    </body>
</html>
