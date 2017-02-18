 <html>
 <head>
   <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
   <link rel="stylesheet" href="stylesheet.css">
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>


 <body>

  <div>
      <?php
        include 'rest-ftn.php';
        $baseurl = 'http://10.30.126.110/~shelby/api/index.php/';
        $bars = json_decode(CallAPI('GET', $baseurl.'businesses/type=bar'), true);
        include 'Nav.php';
      ?>
   </div>

   <div class="row">
     <!-- calandar -->
     <?php include 'calendar.php'; ?>

     <?php
        for ($i=0; $i < 3 ; $i++) {
          echo '<div class="col-sm-offset-1 col-sm-1">
                 <a href="'.str_replace(" ", "-", $bars[$i]['name']).'.php"><img id="image" src="'.$bars[$i]['img-path'].'" width="200px" heigth="200px" alt="Error">
                   <p>'.$bars[$i]['displayName'].'</p>
               </div>';
        }
      ?>
     <!-- <div class="col-sm-offset-1 col-sm-1">
       <a href="test.php"><img id="image" src="Icons/cannibal.jpeg" width="200px" heigth="200px" alt="Error">
         <p> Cannibal and Craft </p>
     </div>
     <div id="pepe" class="col-sm-offset-1 col-sm-1">
       <a href="test.php"><img id="image" src="Icons/jjs.jpeg" width="200px" heigth="200px" alt="Error">
     </div>

     <div class="col-sm-offset-1 col-sm-1">
       <a href="test.php"><img id="image" src="Icons/grubs2.jpg" width="200px" heigth="200px" alt="Error">
     </div> -->


     <div class="col-sm-offset-1 col-sm-2">
       <?php include 'twitter.php'; ?>
     </div>
   </div>
   <div class="row">
   <?php
      for ($i=3; $i < count($bars); $i++) {
        if(($i % 3) == 0) { echo '<div class="col-sm-offset-3 col-sm-1">'; }
        else { echo '<div class="col-sm-offset-1 col-sm-1">'; }
        echo '<a href="'.str_replace(" ", "-", $bars[$i]['name']).'.php"><img id="image" src="'.$bars[$i]['img-path'].'" width="200px" heigth="200px" alt="Error">
                <p>'.$bars[$i]['displayName'].'</p>
            </div>';
        if((($i % 3) + 1) == 3) { echo '</div><div class="row">'; }
      }
    ?>
  </div>

</body>
</html>
