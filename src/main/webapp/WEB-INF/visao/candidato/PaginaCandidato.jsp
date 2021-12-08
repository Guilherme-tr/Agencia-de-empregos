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
        <title>Página do Candidato</title>
    </head>

    <body>
        <div class="container">
            <h1>Bem vindo, ${sessionScope.candidato.nome}! | <a href="logout">Sair</a> </h1>

            <hr>
            <c:if test="${not empty ofertas}">
            <p>Abaixo encontram-se as empresas e ofertas </p>
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">Código</th>
                        <th scope="col">Cargo</th>
                        <th scope="col">Empresa</th>
                        <th scope="col">Horas</th>
                        <th scope="col">Salário</th>
                        <th scope="col"></th>
                    </tr>
                    </thead>
                    
                    <tbody>
                    <c:forEach var="oferta" items="${requestScope.ofertas}">
                        <tr>
                            <td> ${oferta.cargo.codigo} </td>
                            <td> ${oferta.cargo.nome} </td>
                            <td> ${oferta.empresa.nome} </td>
                            <td> ${oferta.horas} </td>
                            <td> ${oferta.salario} </td>
                            <td>
                                <a href="inscrever?id=${oferta.id}" class="btn btn-danger">Inscrever-se</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
            <c:if test="${empty ofertas}">
                Não existe nenhuma oferta que você ainda não se inscreveu.
            </c:if>

            <div class="candidatoCurriculo">
                <hr>
                <h1>Seu curriculo</h1>
                <p>Nome: ${sessionScope.candidato.nome} </p>

                <h3>Experiencias:</h3>
                <c:if test="${empty sessionScope.candidato.experiencia}">
                    Nenhuma experiencia cadastrada
                </c:if>
                <c:if test="${not empty sessionScope.candidato.experiencia}">
                <c:forEach var="cargo" items="${sessionScope.candidato.experiencia}">
                    <hr>
                        <h3>${cargo.nome}</h3>
                        <p>${cargo.codigo}</p>
                        <p>${cargo.descricao}</p>
                    <hr>
                </c:forEach>
                </c:if>
            </div>
            <hr>

            <form method="POST" action="adicionarExperiencia">
            <h3>Adicionar nova Experiência</h3>
            <select class="form-control" id="cargos" name="id">
                <c:forEach var="cargo" items="${requestScope.cargos}">
                    <option value="${cargo.id}"> ${cargo.nome} </option>
                </c:forEach>
            </select>
                <input type="submit" class="btn btn-primary" name="acao" value="Adicionar Experiência">
            </form>
        </div>
    </body>
</html>