<%@ taglib uri="http://www.gate.com.br/gate" prefix="g"%>

<g:template filename="/WEB-INF/views/MAIN.jsp">
    <main>
        <header>
            <img src='Logo.png'/>
            <label>${app.id}</label>
            <label>Versão ${version}</label>
        </header>

        <nav>
            <g-tabbar>
            </g-tabbar>            
        </nav>
        <section>
            <g:insert/>
        </section>
    </main>
</g:template>