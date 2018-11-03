From node:carbon

RUN mkdir -p /usr/recipe

COPY ./app /usr/recipe/app

WORKDIR /usr/recipe/app

RUN npm install

ARG fotoLocation
ARG templocation

RUN ./node_modules/.bin/webpack --env.FOTO_CATALOG=${fotoLocation} --env.TEMP_CATALOG=${templocation}

#RUN npm test

EXPOSE 4003

CMD ["npm", "run", "node-server"]
