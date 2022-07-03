#!/bin/bash
#Version 1.0.0
#Author - Rishon Jonathan.R
#MIT License
<< comment
You have the rights to modify the code with the developers permission. Follow the instructions given by the authors of this software
to claim rights to the software.
Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.
THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
comment
debianDependencies(){
    sudo apt-get update && sudo apt-get full-upgrade
    sudo apt-get install wget git curl dmg2img coreutils gcc g++
}
ubuntuDependencies(){
    sudo add-apt-repository universe
    sudo apt-get update && sudo apt-get full-upgrade
    sudo apt install wget git curl dmg2img coreutils gcc g++
}
archlinuxDependencies(){
    pacman -Syu
    pacman -S wget git curl base-devel gcc g++
    git clone https://aur.archlinux.org/dmg2img.git
    cd dmg2img
    makepkg -sri
}
opensuseDependencies(){
    echo "Choose your Opensuse Release:"
    echo "1.Opensuse  Leap"
    echo "2. Opensuse Tumbleweed"
    while true; do
    read yn
    case $yn in
        [1]* ) wget ftp://ftp.pbone.net/mirror/ftp5.gwdg.de/pub/opensuse/repositories/filesystems/openSUSE_Tumbleweed/x86_64/dmg2img-1.6.5-1.4.x86_64.rpm && sudo zypper install dmg2img-*.x86_64.rpm; break;;
        [2]* ) wget ftp://ftp.pbone.net/mirror/ftp5.gwdg.de/pub/opensuse/repositories/filesystems/SLE_12/x86_64/dmg2img-1.6.5-1.2.x86_64.rpm && sudo zypper install dmg2img-*.x86_64.rpm;;
        * ) echo "Please answer a 1 or a 2.";;
    esac
done
    sudo zypper install gcc-c++
}
fedoraDependencies(){

}
solusDependencies(){

}