#!/bin/bash
PORT=$1
INDEX=$2

echo "curl -i -b cookie${INDEX}.txt -c cookie${INDEX}.txt http://localhost:${PORT}/app/rest/user"
curl -i -b cookie${INDEX}.txt -c cookie${INDEX}.txt http://localhost:${PORT}/app/rest/user
