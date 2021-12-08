<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <meta name="author" content="Lucas Ceoni, Emanoela Sim?o, Vitor Pastore, Jo?o Ara?jo e Souza"/>
        <meta name="description" content="Aula PW3 - Trabalho final"/>
        <meta name="keywords" content="aula, web, java, mvc, servlet, ifsp, ads"/>
        <meta name="date" content="27/01/2021"/>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
              integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <title>Detalhes Oferta</title>
    </head>
    
    <body>
        <div class="container">
            <h1> ${sessionScope.oferta.nome} </h1>
            
            <c:if test="${not empty oferta.candidatos}">
                <h2>Candidatos para a vaga corrente</h2>
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">Nome</th>
                        <th scope="col">Código Curso Superior</th>
                        <th scope="col">Curso Superior</th>
                    </tr>
                    </thead>
                    
                    <tbody>
                    <c:forEach var="candidato" items="${requestScope.oferta.candidatos}">
                        <tr>
                            <td> ${candidato.nome} </td>
                            <td> ${candidato.codigoCS} </td>
                            <td>
                                <c:if test="${ not empty candidato.nomeCS}"> ${candidato.nomeCS} </c:if>
                                <c:if test="${empty candidato.nomeCS}"> N/A </c:if>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
            
            <c:if test="${empty oferta.candidatos}">
                <h2>Não há candidatos cadastrados para esta vaga.</h2>
            </c:if>
    
            <a href="excluir-oferta&numero=${oferta.id}" class="btn btn-danger"> Excluir Oferta </a>
            <a href="empresa-pagina-inicial" class="btn btn-danger"> Voltar </a>
        </div>

        
    </body>
</html>