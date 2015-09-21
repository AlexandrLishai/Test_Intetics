/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function empty_form_client ()

{

    var txtFirstName = document.getElementById('FirstName').value;
    var txtLastName = document.getElementById('LastName').value;
    var txtDateofBirth = document.getElementById('DateofBirth').value;
    var txtPhone = document.getElementById('Phone').value;
    var txtAddress = document.getElementById('Address').value;
    var txtEmail = document.getElementById('Email').value;    

    if(txtFirstName == '')

    {

        alert('Enter text to FirstName.');

        return false;

    } 
    
    if(txtLastName == '')

    {

        alert('Enter text to LastName.');

        return false;

    } 
    
    if(txtDateofBirth == '')

    {

        alert('Enter data to DateofBirth.');

        return false;

    } 
    
    if(txtPhone == '')

    {

        alert('Enter text to Phone.');

        return false;

    } 
    
    if(txtAddress == '')

    {

        alert('Enter text to Address.');

        return false;

    } 
    
    if(txtEmail == '')

    {

        alert('Enter text to Email.');

        return false;

    } 
    

    return true;

}

function empty_form_car ()

{

    var txtMake = document.getElementById('Make').value;
    var txtModel = document.getElementById('Model').value;
    var txtYear = document.getElementById('Year').value;
    var txtVIN = document.getElementById('VIN').value;
        

    if(txtMake == '')

    {

        alert('Enter text to Make.');

        return false;

    } 
    
    if(txtModel == '')

    {

        alert('Enter text to Model.');

        return false;

    } 
    
    if(txtYear == '')

    {

        alert('Enter number to Year.');

        return false;

    } 
    
    if(txtVIN == '')

    {

        alert('Enter text to VIN.');

        return false;

    }     
   
    

    return true;

}

function empty_form_order ()

{

    var txtDate = document.getElementById('Date').value;
    var txtOrderAmount = document.getElementById('OrderAmount').value;
          

    if(txtDate == '')

    {

        alert('Enter date to Date.');

        return false;

    } 
    
    if(txtOrderAmount == '')

    {

        alert('Enter text to OrderAmount.');

        return false;

    }     
   
    

    return true;

}
