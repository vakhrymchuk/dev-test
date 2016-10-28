FROM ubuntu:16.04

RUN apt-get update && apt-get install -y \
    openjdk-8-jdk \
    git \
    maven \
    gradle \
 && rm -rf /var/lib/apt/lists/*
RUN apt-get update && apt-get install -y curl \
 && rm -rf /var/lib/apt/lists/*
RUN curl -sL https://deb.nodesource.com/setup_6.x | bash - \
 && apt-get install -y nodejs \
 && rm -rf /var/lib/apt/lists/*
RUN curl -O https://static.rust-lang.org/rustup.sh \
 && sh rustup.sh --disable-sudo \
 && rm rustup.sh

COPY example /data/example
ARG repo
ARG branch
WORKDIR /data
RUN git clone $repo dev-test -b $branch
WORKDIR dev-test
RUN bash build.sh
