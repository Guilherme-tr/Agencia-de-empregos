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
        <title>P?gina do Candidato</title>
    </head>
    
    <body>
        <div class="container">
            <h1> Bem vindo, ${sessionScope.empresa.nome} | <a href="loginEmpresa">Sair</a> </h1>
        
            <c:if test="${not empty ofertas}">
                <h2>Ofertas cadastradas</h2>
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">Código</th>
                        <th scope="col">Cargo</th>
                        <th scope="col">Salário</th>
                        <th scope="col">Horas</th>
                    </tr>
                    </thead>
        
                    <tbody>
                    <c:forEach var="oferta" items="${requestScope.ofertas}">
                        <tr>
                            <td> ${oferta.codigo} </td>
                            <td> ${oferta.cargo} </td>
                            <td> ${oferta.salario} </td>
                            <td> ${oferta.horas} </td>
                            <td>
                                <a href="detalhes-oferta?id=${oferta.id}" class="btn btn-primary"> Detalhes </a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
        
                <a href="pagina-cadastro-oferta" class="btn btn-primary"> Cadastrar Oferta </a>
            </c:if>
        
            <c:if test="${empty ofertas}">
                <h2>Você ainda não possui ofertas de emprego cadastradas</h2>
                <a href="pagina-cadastro-oferta" class="btn btn-primary"> Cadastrar Oferta </a>
            </c:if>
        </div>

    </body>
</html>