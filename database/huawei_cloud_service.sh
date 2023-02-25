#!/bin/sh
apt update && apt upgrade
apt install postgresql
adduser --shell /bin/sh ecs
printf 'PW : ' && read __password
echo "ecs:$__password" | chpasswd
echo "listen_addresses = '*'" >> postgresql.conf
echo "listen_addresses = '*'" >> /etc/postgresql/14/main/postgresql.conf