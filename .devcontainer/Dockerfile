FROM mcr.microsoft.com/devcontainers/java:1-21-bookworm

USER root

RUN rm -f /etc/apt/sources.list.d/yarn.list

RUN apt-get update && export DEBIAN_FRONTEND=noninteractive \
    && apt-get install -y locales jq maven vim\
    && sed -i -e 's/# ja_JP.UTF-8 UTF-8/ja_JP.UTF-8 UTF-8/' /etc/locale.gen \
    && locale-gen \
    && update-locale LANG=ja_JP.UTF-8

ENV LANG ja_JP.UTF-8
ENV LC_ALL ja_JP.UTF-8

USER vscode