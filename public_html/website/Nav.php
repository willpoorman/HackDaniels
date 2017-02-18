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
  <nav class="navbar navbar-inverse">
    <div class="container-fluid">
      <div class="navbar-header">
        <a class="navbar-brand" href="home.php">Feed Me</a>
      </div>
        <ul class="nav navbar-nav" >
          <li><a href="bars.php">Bars</a></li>
          <li><a href="restaurants.php">Restaurants</a></li>
        </ul>
        <form class="navbar-form navbar-left" action="test.php" method='post'>
          <div class="input-group">
            <input type="text" class="form-control" name='whichBus' placeholder="Search">
            <div class="input-group-btn">
              <button class="btn btn-default" type="submit">
                <i class="glyphicon glyphicon-search"></i>
              </button>
              </div>
            </input>
          </div>
        </form>

        <ul class="nav navbar-nav">
          <li class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#">Filter <span class="caret"></span></a>
            <ul class="dropdown-menu">
              <li>
                <input type="checkbox" name="filter1" value="filter1">I have a pen<br>
                <input type="checkbox" name="filter2" value="filter2">I have a apple<br>
                <input type="checkbox" name="filter3" value="filter3">uh. apple pen<br>
            </li>
          </ul>
        </ul>
        <ul class="nav navbar-nav navbar-right">
          <li><a href="#">Add Place</a></li>
          <li><a href="#"><span class="glyphicon glyphicon-user">Login</span>
        </ul>
      </div>
    </div>
  </nav>

</body>
</html>
