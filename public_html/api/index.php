<?php
use \Psr\Http\Message\ServerRequestInterface as Request;
use \Psr\Http\Message\ResponseInterface as Response;
require 'vendor/autoload.php';

$app = new \Slim\App;
$mongo = new MongoDB\Client();
$db = $mongo->hackDaniels;

// Generic Versions of Routes
$app->get('/', function (Request $request, Response $response) {
  global $db;

  $data = ['Welcome' => "Welcome to the Hack Daniel's API"];
  $response = $response->withJson($data, 200);
  return $response;
});

$app->get('/{collection}', function (Request $request, Response $response) {
  global $db;
  $whichColl = $request->getAttribute('collection');
  $collection = $db->$whichColl;
  $cursor = $collection->find();
  foreach ($cursor as $document) {
    $data[] = $document;
  }
  $response = $response->withJson($data, 200);
  return $response;
});

$app->get('/{collection}/{key}={value}', function (Request $request, Response $response) {
  global $db;
  $whichColl = $request->getAttribute('collection');
  $key = $request->getAttribute('key');
  $value = $request->getAttribute('value');

  $collection = $db->$whichColl;
  if ($key == 'id') {
    $cursor = $collection->find(['_id' => new MongoDB\BSON\ObjectID($value)]);
  } else if ($key == 'type') {
    $cursor = $collection->find([$key => $value]);
  } else {
    $cursor = $collection->find([$key => $value]);
  }

  foreach ($cursor as $document) {
    $data[] = $document;
  }

  $response = $response->withJson($data, 200);
  return $response;
});

$app->post('/{collection}/create', function (Request $request, Response $response) {
  global $db;
  $whichColl = $request->getAttribute('collection');
  $parsedBody = $request->getParsedBody();
  $collection = $db->$whichColl;
  $results = $collection->insertOne($parsedBody);
  $response = $response->withJson($results->getInsertedId(), 200);
  return $response;
});

$app->post('/{collection}/update/id={id}', function (Request $request, Response $response) {
  global $db;
  $whichColl = $request->getAttribute('collection');
  $id = $request->getAttribute('id');
  $parsedBody = $request->getParsedBody();
  $collection = $db->$whichColl;
  $results = $collection->updateOne(['_id' => new MongoDB\BSON\ObjectID($id)], ['$set' => $parsedBody]);
  // foreach ($cursor as $document) {
  //   $data[] = $document;
  // }
  $response = $response->withJson($results->isAcknowledged(), 200);
  return $response;
});

// $app->get('/{collection}/test', function (Request $request, Response $response) {
//   global $db;
//   $whichColl = $request->getAttribute('collection');
//   $collection = $db->$whichColl;
//   $cursor = $collection->find(['_id' => new MongoDB\BSON\ObjectID('58a848a83a4f8d5b8f232f02')]);
//   foreach ($cursor as $document) {
//     $data[] = $document;
//   }
//   $response = $response->withJson($data, 200);
//   return $response;
// });

$app->run();