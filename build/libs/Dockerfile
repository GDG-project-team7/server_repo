# 'node:21-alpine' 이미지를 기반으로 하는 빌드단계를 시작합니다.
# 이 단계의 이름은 development라고 지정합니다.
FROM node:21-alpine AS development

# 빌드 시간동안 사용할 변수 'NODE_ENV'를 선언하고, 기본값으로 'development'를 설정합니다.
ARG NODE_ENV=development

# ARG로 설정된 'NODE_ENV' 값을 이미지내에서 실행되는 애플리케이션에 'development'로 환경설정합니다.
ENV NODE_ENV=${NODE_ENV}

# 이미지 내의 작업 디렉터리를 '/app'으로 설정합니다.
WORKDIR /app

# 로컬 컴퓨터 디렉터리 내에서 package.json, package-lock.json 파일을 /app 으로 복사합니다.
COPY package*.json ./

# package.json에 작성된 npm 패키지들을 설치합니다.
RUN npm install

# 로컬 컴퓨터에 있는 현재 디렉터리의 모든 파일을 /app으로 복사합니다.
COPY . .

# package.json에 정의된 build 스크립트를 실행해 애플리케이션을 빌드합니다.
RUN npm run build

# 새로운 빌드 단계를 시작하며, 이 단계는 'production'으로 이름을 지정합니다.
FROM node:21-alpine AS production

ARG NODE_ENV=production
ENV NODE_ENV=${NODE_ENV}

WORKDIR /app

# 'development' 빌드 단계에서 생성된 '/app/dist' 디렉터리를 현재 작업 '/app' 디렉터리에 복사합니다.
COPY --from=development /app/dist ./dist

COPY package*.json ./

# devDependencied를 제외하고, dependencied에 명시된 npm 패키지들만 설치합니다.
RUN npm install --only=production

# 컨테이너가 시작될 때 실행할 명령어를 지정합니다. node dist/main 명령어로 애플리케이션을 실행합니다.
CMD ["node","dist/main"]