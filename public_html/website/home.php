<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link rel="stylesheet" href="stylesheet.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>



<body>
  <?php
  include 'rest-ftn.php';
  $baseurl = 'http://10.30.126.110/~shelby/api/index.php/';
  $businesses = json_decode(CallAPI('GET', $baseurl.'businesses'), true);


  include 'Nav.php';
  ?>

  <div class="row">
    <?php include 'calendar.php'; ?>

    <!-- carousel -->
    <div class="col-sm-offset-2 col-sm-3">
      <div id="myCarousel" class="carousel slide" data-ride="carousel">
        <!-- Indicators -->
        <ol class="carousel-indicators">
          <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
          <li data-target="#myCarousel" data-slide-to="1"></li>
          <li data-target="#myCarousel" data-slide-to="2"></li>
          <li data-target="#myCarousel" data-slide-to="3"></li>
        </ol>

        <!-- replace pictures with shit-->
        <!-- Wrapper for slides -->
        <div id=mycarousel class="carousel-inner" role="listbox">
          <?php
            for ($i=0; $i < 3; $i++) {
              $dealurl = $baseurl.'deals/business='.str_replace(" ", "%20", $businesses[$i]['name']);
              $deals = json_decode(CallAPI('GET', $dealurl), true);
              if ($i == 0) { echo '<div class="item active">'; }
              else { echo '<div class="item">'; }

              echo '<a href="'.str_replace(" ", "-", $businesses[$i]['name']).'.php"><img id="image" src="'.$businesses[$i]['img-path'].'" width="500px" heigth="500px" alt="Error">
                    <div class="carousel-caption">
                      <p id=cana>'.$deals[0]['text'].'</p>
                    </div></a>
                  </div>';
            }
          ?>
        </div>

        <!-- Left and right controls -->
        <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
          <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
          <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
          <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
          <span class="sr-only">Next</span>
        </a>
      </div>
    </div>

    <!--twitter integration -->
    <div class="col-sm-offset-2 col-sm-2">
      <?php include 'twitter.php'; ?>
    </div>
    <!-- end twitter -->


  </div>
  <!-- carousel end -->

  </body>

<html>
