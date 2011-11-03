<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<html>
<head>
    <sj:head jqueryui="true"/>

    <style type="text/css">
        .errorMessage {
            color: #FF0000;
        }
    </style>

</head>
<body>
    <div style="text-align: center">
        <h2>Address Form</h2>
    </div>

    <div>
        <s:actionmessage />

        <s:form action="saveAddress" >

            <s:textfield name="firstName" label="First Name" required="true" />
            <s:textfield name="lastName" label="Last Name" />


            <s:submit />


        </s:form>

    </div>

</body>
</html>
