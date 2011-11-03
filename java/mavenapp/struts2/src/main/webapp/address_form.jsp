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


    <script type="text/javascript">
        function validateMinSize() {
            if($("#firstName").val().length < 5) {
                alert("First name should be at least 5 characters length.");
                return false;
            }
            return true;
        }

    </script>
</head>
<body>
    <div style="text-align: center">
        <h2>Address Form</h2>
    </div>

    <div>
        <s:actionmessage />

        <s:form action="saveAddress" onsubmit="return validateMinSize()">

            <s:textfield id="firstName" name="firstName" label="First Name" required="true" />
            <s:textfield id="lastName" name="lastName" label="Last Name" />


            <s:submit />


        </s:form>

    </div>

</body>
</html>
