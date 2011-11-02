<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>


<div>

    <p> Jquery Ajax select box </p>

    <s:url id="emailActionUrl" action="emailLookupAction"/>
    <sj:select
            href="%{emailActionUrl}"
            id="_emailId"
            name="_email"
            label="Select Email"
            list="emails"
            listKey="emailId"
            listValue="emailId"
            emptyOption="false"
            headerKey="-1"
            headerValue="Please Select a Email Id"/>


    <p> Auto complete text box </p>

    <s:url id="departmentActionUrl" action="departmentLookupAction" />
    <sj:autocompleter
            href="%{departmentActionUrl}"
            id="_departmentId"
            name="_department"
            list="departments"/>



</div>
