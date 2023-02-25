#!/bin/sh
apt update
apt upgrade
apt install postgres --no-install-recommends
adduser --shell /bin/zsh ninja_van
echo 'ninja_van:passwordis123' | chpasswd

echo "listen_addresses = '*'" >> postgresql.conf