<%@ page pageEncoding="UTF-8" %>

<!DOCTYPE html>

<html>

    <head>
		<meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

		<!-- Bootstrap 4.0  -->
		<%@include file="Resources/Resources_bootstrap_4.0.html" %>
		
		<!-- CSS for Head.html -->
		<link rel="stylesheet" href="Resources/styles_index.css">

    </head>

    <body>
    
    
			<%@include file="Templates/Head.jsp" %>
			
			<div class=jumbotron>
			 <div class=container>
			
			 </div>
			     <br/>
			<br/>
     

  <form action="CreerCompte" method="post">
  
  	
  	    <div class="form-group ">
	      <label for="inputState">Je veux ouvrir :</label>
	      <select name="compte" id="inputState" class="form-control">
	        <option selected>Compte Bancaire</option>
	        <option>Livret A</option>
	        <option>compte titre</option>
	      </select>
	    </div>
	  <div class="form-row">
	    <div class="form-group col-md-6">
	      <label for="inputName4">Nom </label>
	      <input type="text" class="form-control" name="nom" id="inputName4" placeholder="Serais" required>
	    </div>
	    
	    <div class="form-group col-md-6">
	      <label for="inputName4">Prénom </label>
	      <input type="text" class="form-control" name="prenom" id="inputName4" placeholder="Sebastien" required>
	    </div>
	    
	    <div class="form-group col-md-6">
	      <label for="inputName4">Tel : </label>
	      <input type="text" class="form-control" name="telephone" id="inputName4" placeholder="0769458855" required>
	    </div>
	    
	  </div>
	  <div class="form-group">
	    <label for="inputAddress">Date de Naissance : </label>
	    <input type="date" class="form-control" name="date" id="inputdate" placeholder="10/10/1990" required>
	  </div>
	  
	  <div class="form-group">
	    <label for="inputAddress">Adresse</label>
	    <input type="text" class="form-control" name="adresse" id="inputAddress" placeholder="1 rue jean mermoz" required>
	  </div>
	  <div class="form-group">
	    <label for="inputAddress2">Adresse mail</label>
	    <input type="text" class="form-control" name="email" id="inputAddress2" placeholder="sebastien@esigelec.fr"  required />
	    
	  </div>
	  <div class="form-row">
	    <div class="form-group col-md-6">
	      <label for="inputCity">Ville</label>
	      <input type="text" name="ville" class="form-control" id="inputCity" required>
	    </div>
	    <div class="form-group col-md-4">
	      <label for="inputState">Pays</label>
	      <select id="inputState" name="pays" class="form-control">
	        <option selected>France</option>
	        <option>Allemagne</option>
	        <option>Suisse</option>
	      </select>
	    </div>
	    
	    <div class="form-group">
                            <label  for="fichier">Ajouter Fichier : (de Type PDF)</label>
                            <input class="form-control col-sm-8" type="hidden" name="MAX_FILE_SIZE" value="30720" />
                            <input class="form-control col-sm-8 " id="fichier" type="file" name="fichier" />
                            
        </div>
	    
	  </div>
	  
	  <button type="submit" class="btn btn-primary">Envoyer</button>
	  <a href="pageVerification.jsp" >verifier votre mail</a>
</form>


</div>
    </body>

</html>
