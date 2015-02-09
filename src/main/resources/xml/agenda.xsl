<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:xsi="http://myNameSpace.com">

    <xsl:template match="/">
        <html>
            <body>
                <h2>Agenda</h2>
                <h3>Contactos</h3>
                <table border="1">
                    <tr bgcolor="#9acd32">
                        <th>Alias</th>
                        <th>Nombre</th>
                        <th>Apellidos</th>
                        <th>E-mail</th>
                        <th>Telefono</th>
                    </tr>
                    <xsl:for-each select="xsi:agenda/xsi:contactos/xsi:contacto">
                        <tr>
                            <td>
                                <xsl:value-of select="@alias"/>
                            </td>
                            <td>
                                <xsl:value-of select="xsi:nombre"/>
                            </td>
                            <td>
                                <xsl:value-of select="xsi:apellidos"/>
                            </td>
                            <td>
                                <xsl:value-of select="xsi:email"/>
                            </td>
                            <td>
                                <xsl:value-of select="xsi:telefono"/>
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
                <h3>Contactos</h3>
                <table border="1">
                    <tr bgcolor="#9acd32">
                        <th>Titulo</th>
                        <th>Lugar</th>
                        <th>Fecha</th>
                        <th>Hora</th>
                    </tr>
                    <xsl:for-each select="xsi:agenda/xsi:citas/xsi:cita">
                        <tr>
                            <td>
                                <xsl:value-of select="xsi:titulo"/>
                            </td>
                            <td>
                                <xsl:value-of select="xsi:lugar"/>
                            </td>
                            <td>
                                <xsl:value-of select="xsi:fecha"/>
                            </td>
                            <td>
                                <xsl:value-of select="xsi:hora"/>
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>