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
    <title>Administração</title>
</head>

<body>
<div class="container">

    <h1>Página de Administração</h1>
    <p>Seja bem vindo, admin | <a href="logout">Sair</a></p>
    <div class="row mt-5">
        <div class="col-6">
            <h2>Cargos cadastrados</h2>
            <c:if test="${not empty cargos}">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">Código</th>
                        <th scope="col">Nome</th>
                        <th scope="col">Descrição</th>
                        <th scope="col">Excluir</th>
                    </tr>
                    </thead>

                    <hr>

                    <tbody>
                    <c:forEach var="cargo" items="${requestScope.cargos}">
                        <tr>
                            <td> ${cargo.codigo} </td>
                            <td> ${cargo.nome} </td>
                            <td> ${cargo.descricao} </td>
                            <td>
                                <a href="excluir-cargo?codigo=${cargo.codigo}">
                                    <button type="button" class="btn btn-danger">Excluir</button>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
            <hr>

            <h2>Cadastre um novo cargo</h2>
            <form method="POST" action="cadastrar-cargo" id="cadCargo">
                <div class="row">
                    <div class="col">
                        <div class="form-group">
                            <label class="form-check-label" for="codigo">Código</label>
                            <input class="form-control" id="codigo" type="text" placeholder="Código" name="codigo">
                        </div>
                        <div class="form-group">
                            <label class="form-check-label" for="nome">Nome</label>
                            <input class="form-control" id="nome" type="text" placeholder="Nome" name="nome">
                        </div>
                    </div>
                    <div class="col">
                        <div class="form-group">
                            <label class="form-check-label" for="descricao">Descrição</label>
                            <textarea class="form-control" form="cadCargo" id="descricao" type="text"
                                      placeholder="Descrição do cargo" name="descricao"></textarea>
                        </div>
                    </div>
                </div>

                <input type="submit" class="btn btn-primary" value="Cadastrar">
                <input type="hidden" name="acao" value="GravarCargo">
            </form>
        </div>

        <div class="col-6">
            <h2>Empresas cadastradas</h2>
            <c:if test="${not empty empresas}">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">Código</th>
                        <th scope="col">Nome</th>
                        <th scope="col">Login</th>
                        <th scope="col">Editar</th>
                    </tr>
                    </thead>

                    <hr>

                    <tbody>
                    <c:forEach var="empresa" items="${requestScope.empresas}">
                        <tr>
                            <td> ${empresa.codigo} </td>
                            <td> ${empresa.nome} </td>
                            <td> ${empresa.login} </td>
                            <td>
                                <a href="editar-empresa?codigo=${empresa.codigo}">
                                    <button type="button" class="btn btn-primary">Editar</button>
                                </a>
                            </td
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </div>
    </div>
</div>

</body>
</html>