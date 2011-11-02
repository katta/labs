<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>

<html>
    <head>
        <sj:head jqueryui="true"/>

        <script type="text/javascript">
            function loadDiv() {
                 if ($("#chkEmailRequired").is(":checked")) {
                     $("#divAddressForm").show();
                     $.publish("loadEmailDivTopic");
                 } else {
                     $("#divAddressForm").hide();
                 }

            }

            $.subscribe("loadEmailDivTopic", function(event, data) {
                //alert("topic raised") ;
            } );

        </script>
    </head>
    <body>
        <h2>This page demonstrates struts ajax jquery div and select widgets </h2>

        <s:checkbox label="Select this to load div" name="emailRequired" id="chkEmailRequired" onchange="loadDiv()"/>

        <div id="divAddressForm">
            <s:url id="addressFormUrl" action="addressform"/>

            <sj:div href="%{addressFormUrl}" indicator="loading" bindOn="true" listenTopics="loadEmailDivTopic">
                <img id="loading" src="images/loading.gif" style="display:none"/>
            </sj:div>
        </div>
    </body>
</html>
