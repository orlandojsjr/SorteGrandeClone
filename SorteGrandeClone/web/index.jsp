<%-- 
    Document   : index
    Created on : 21/09/2013, 10:33:25
    Author     : pg3651
--%>


<%@page import="sorteGrande.SorteGrande"%>
<%@page import="java.util.List"%>
<%@page import="sorteGrande.Resultado"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>JSP Page</title>
    </head>
    <body>        
        <%            
            List<Resultado> listaMegaSena = new Resultado().getListaResultado("MEGA_SENA");
            List<Resultado> listaQuina = new Resultado().getListaResultado("QUINA");
            
            for (Resultado resultado : listaMegaSena)    ;
        %>

        <table border="1">
            <tr>
                <td colspan="2">Resultados MegaSena</td>                                               
            </tr>
            <tr>
                <td>Resultado</td>
                <td>Data</td>                               
            </tr>
            <%for (Resultado resultado : listaMegaSena) {%>
            <tr>
                <td><%= resultado.getResultado()%></td>                               
                <td><%= resultado.getData()%></td>                               
            </tr>
            <%}%>
        </table>
        <br/><br/>
        <table border="1">            
            <tr>
                <td colspan="2">Resultados Quina</td>                                               
            </tr>
            <tr>
                <td>Resultado</td>                
                <td>Data</td>
            </tr>
            <%for (Resultado resultado : listaQuina) {%>
            <tr>
                <td><%= resultado.getResultado()%></td>     
                <td><%= resultado.getData()%></td>                               
            </tr>
            <%}%>
        </table>

    </body>
</html>
