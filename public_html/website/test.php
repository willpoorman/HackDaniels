<?php
  include 'rest-ftn.php';
  $baseurl = 'http://10.30.126.110/~shelby/api/index.php/';
  $table = 'businesses';
  $url = $baseurl.$table.'/name='.$_POST['whichBus'];
  $business = json_decode(CallAPI('GET', $url), true);
  // $dealurl = $baseurl.'deals/business='.str_replace(" ", "%20", $businesses[0]['name']);
  // echo $url;
  // $deals = json_decode(CallAPI('GET', $url), true);
  var_dump($business);
  // for ($i=0; $i < 3; $i++) {
  //   // $string = str_replace(" ", "-", $businesses[$i]->name);
  //   echo str_replace(" ", "-", $businesses[$i]->name);
  // }

?>
