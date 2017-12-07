#! /bin/bash
cvlc -vvv $1 --sout-keep --sout "#transcode{vcodec=VP80,vb=2000}:duplicate{dst=file{mux=webm,dst=$4},dst=http{mux=webm,dst=:$2/webcam$3},select=noaudio}"
