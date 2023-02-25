#!/bin/sh
apt update
apt upgrade
apt install postgresql
adduser --shell /bin/sh ninja_van
echo 'ninja_van:passwordis123' | chpasswd
echo "listen_addresses = '*'" >> postgresql.conf
echo "listen_addresses = '*'" >> /etc/postgresql/14/main/postgresql.conf