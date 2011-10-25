<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<html>
    <head>
        <sj:head/>
    </head>
    <body>
        <h2>Hello World! 132</h2>

        <div>
            <s:url id="emailActionUrl" action="emailAction"/>
            Select Email : <sj:select
                    href="%{emailActionUrl}"
                    id="_emailId"
                    name="_email"
                    list="emails"
                    listKey="emailId"
                    listValue="emailId"
                    emptyOption="false"
                    headerKey="-1"
                    headerValue="Please Select a Email Id"/>
        </div>
    </body>
</html>
