1. Выполните 

   ```
   docker run hello-world
   ```

   Убедитесь, что видите строки: 

   ```
   Hello from Docker! This message shows that your installation appears to be working correctly.
   ```

   ```
   C:\Users\Igor>docker run hello-world
   Unable to find image 'hello-world:latest' locally
   latest: Pulling from library/hello-world
   2db29710123e: Pull complete
   Digest: sha256:bfea6278a0a267fad2634554f4f0c6f31981eea41c553fdf5a83e95a41d40c38
   Status: Downloaded newer image for hello-world:latest
   
   Hello from Docker!
   This message shows that your installation appears to be working correctly.
   
   To generate this message, Docker took the following steps:
   
     1. The Docker client contacted the Docker daemon.
     2. The Docker daemon pulled the "hello-world" image from the Docker Hub.
        (amd64)
     3. The Docker daemon created a new container from that image which runs the
        executable that produces the output you are currently reading.
     4. The Docker daemon streamed that output to the Docker client, which sent it
        to your terminal.
   
   To try something more ambitious, you can run an Ubuntu container with:
    $ docker run -it ubuntu bash
   
   Share images, automate workflows, and more with a free Docker ID:
    https://hub.docker.com/
   
   For more examples and ideas, visit:
    https://docs.docker.com/get-started/
   ```

2.  Узнайте размер образа hello-world

   ```
   C:\Users\Igor>docker images
   REPOSITORY    TAG       IMAGE ID       CREATED        SIZE
   postgres      14.2      5cd1494671e9   10 days ago    376MB
   hello-world   latest    feb5d9fea6a5   6 months ago   13.3kB
   ```

   13.3kB

3. Посмотрите какие контейнеры сейчас запущены

   ```
   C:\Users\Igor>docker ps
   CONTAINER ID   IMAGE     COMMAND   CREATED   STATUS    PORTS     NAMES
   ```

4. в одной консоли: выполните 

   ```
   docker run -it ubuntu bash
   ```

   ```
   C:\Users\Igor>docker run -it ubuntu bash
   Unable to find image 'ubuntu:latest' locally
   latest: Pulling from library/ubuntu
   4d32b49e2995: Pull complete
   Digest: sha256:bea6d19168bbfd6af8d77c2cc3c572114eb5d113e6f422573c93cb605a0e2ffb
   Status: Downloaded newer image for ubuntu:latest
   root@b225f2f6bce7:/#
   ```

   

5. В другой консоли еще раз посмотрите работающие контейнеры, убедитесь, что есть контейнер с образом ubuntu

   ```
   C:\Users\Igor>docker ps
   CONTAINER ID   IMAGE     COMMAND   CREATED          STATUS          PORTS     NAMES
   b225f2f6bce7   ubuntu    "bash"    54 seconds ago   Up 53 seconds             great_meninsky
   ```



6. Вернитесь в консоль, где вы запустили "docker run -it ubuntu bash". 

   Начните с выполнения команды ls, "походите" по файловой системе, убедитесь, что это "какая-то другая" операционная система, перейдите в каталог home и в нем создайте новый каталог test, выполните exit и убедитесь, что вернулись в "свою" операционную систему.

   ```
   root@b225f2f6bce7:/# ls
   bin  boot  dev  etc  home  lib  lib32  lib64  libx32  media  mnt  opt  proc  root  run  sbin  srv  sys  tmp  usr  var
   root@b225f2f6bce7:/# cd /home
   root@b225f2f6bce7:/home# mkdir test
   root@b225f2f6bce7:/home# cd test
   root@b225f2f6bce7:/home/test# exit
   exit
   
   C:\Users\Igor>
   ```

7. Еще раз выполните 

   ```
   docker run -it ubuntu bash
   ```

   перейдите к каталог home, убедитесь, что созданного вами каталога test нет.
   Очень важный пункт: подумайте, куда пропал каталог test.

   ```
   C:\Users\Igor>docker run -it ubuntu bash
   root@65d964613339:/# cd /home
   root@65d964613339:/home# cd /test
   bash: cd: /test: No such file or directory
   root@65d964613339:/home# cd test
   bash: cd: test: No such file or directory
   root@65d964613339:/home#
   ```

   <u>Это другой контейнер.</u>

8. Запустите PostgreSQL 13.1 в докере, подключитесь к запущенному контейнеру с базой.

```
C:\Users\Igor>docker run -e POSTGRES_PASSWORD=postgres -d postgres:13.1
Unable to find image 'postgres:13.1' locally
13.1: Pulling from library/postgres
45b42c59be33: Pull complete
40adec129f1a: Pull complete
b4c431d00c78: Pull complete
2696974e2815: Pull complete
564b77596399: Pull complete
5044045cf6f2: Pull complete
d736e67e6ac3: Pull complete
390c1c9a5ae4: Pull complete
2b9eab478282: Pull complete
8adb9d662bf1: Pull complete
0240e6d594fc: Pull complete
b06896cbd68e: Pull complete
747e5c9db333: Pull complete
411ac8e8a459: Pull complete
Digest: sha256:26180996f7d804993f9c90398615d1269709a799b5eb79109292843a1c7cd851
Status: Downloaded newer image for postgres:13.1
0f726f569769895af2a04b01f0256cd42df02b5a1a73fa047754be2b6fda393f

C:\Users\Igor>docker ps
CONTAINER ID   IMAGE           COMMAND                  CREATED          STATUS          PORTS      NAMES
0f726f569769   postgres:13.1   "docker-entrypoint.s…"   27 seconds ago   Up 26 seconds   5432/tcp   festive_euclid

C:\Users\Igor>docker exec -it 0f726f569769 bash
root@0f726f569769:/#

```





6. Запустите PostgreSQL 13.1 в докере. Подключитесь к запущенному контейнеру с базой. Создайте таблицу tTestDoc с любыми полями. Остановите и удалите контейнер.

```
root@0f726f569769:/# psql -U postgres
psql (13.1 (Debian 13.1-1.pgdg100+1))
Type "help" for help.

postgres=# create table tTestDoc(id serial);
CREATE TABLE
postgres=#

postgres-# \q
root@0f726f569769:/# exit
exit

C:\Users\Igor>docker ps
CONTAINER ID   IMAGE           COMMAND                  CREATED          STATUS          PORTS      NAMES
0f726f569769   postgres:13.1   "docker-entrypoint.s…"   11 minutes ago   Up 11 minutes   5432/tcp   festive_euclid

C:\Users\Igor>docker stop 0f726f569769
0f726f569769

C:\Users\Igor>docker rm 0f726f569769
0f726f569769

```

7. Еще раз запустите контейнер с базой. Подключитесь к базе данных, убедитесь, что таблицы tTestDoc нет. Подумайте, почему пропала таблица. Остановите контейнер работа завершена.

   ```
   C:\Users\Igor>docker run -e POSTGRES_PASSWORD=postgres -d postgres:13.1
   7b99fc004477bc91f6f6bf2f38c1f86de373aaa923c4c514c66f9386a0327c9f
   
   C:\Users\Igor>docker ps
   CONTAINER ID   IMAGE           COMMAND                  CREATED         STATUS         PORTS      NAMES
   7b99fc004477   postgres:13.1   "docker-entrypoint.s…"   7 seconds ago   Up 6 seconds   5432/tcp   fervent_mendeleev
   
   C:\Users\Igor>docker exec -it 7b99fc004477 bash
   root@7b99fc004477:/# psql -U postgres
   psql (13.1 (Debian 13.1-1.pgdg100+1))
   Type "help" for help.
   
   postgres=# select * from tTestDoc;
   ERROR:  relation "ttestdoc" does not exist
   LINE 1: select * from tTestDoc;
                         ^
   postgres=# \q
   root@7b99fc004477:/# exit
   exit
   
   C:\Users\Igor>docker stop 7b99fc004477
   7b99fc004477
   
   C:\Users\Igor>docker rm 7b99fc004477
   7b99fc004477
   
   C:\Users\Igor>docker rmi postgres:13.1
   Untagged: postgres:13.1
   Untagged: postgres@sha256:26180996f7d804993f9c90398615d1269709a799b5eb79109292843a1c7cd851
   Deleted: sha256:407cece1abfffb1e84b5feb8a763f3773c905c409e52c0ee5f57f33acf0c10c6
   Deleted: sha256:8f9149c1eb366e8021f46bf04ef5b94b28a3761277eccbedcd4227c4e9ac53c2
   Deleted: sha256:918694674013f221ad6b37ffbe52325fcdd2894c7013128ab4f477a9fdc13a6e
   Deleted: sha256:d8a49e3093cae597641633cc150c9140794db2a7b0f45ba6424a7a74878b4b4f
   Deleted: sha256:43dcac0663092dabe9beb0f243dfa7a4802a17fdc172e3dacebe2d8c239014a5
   Deleted: sha256:9dfb564f1890358f1b3bcc0001db78371862f250dbdd83604df56b5154281640
   Deleted: sha256:d668255fd2cc3b8f715f18dd00df3c18b27eff9be0a7e3e533ad6217e4b3f564
   Deleted: sha256:ca3c5081229cb514c41751db96e1ac598913de5d8da9994d4defbdb9be05ff92
   Deleted: sha256:095b775154b93a794a482b6a9bd521b9f98da9b1421c50040591ef75b820788d
   Deleted: sha256:fdfae235f3f42e689dd14060e032492eccffb5e4a3a7279cd2b2a611f55bf52f
   Deleted: sha256:3bded084200f02a5824dcf38e1a3eb935e9c5f3c9cd2c83f6383273dccecb334
   Deleted: sha256:6853a0d0a62ea3128a5fbec45265296d467fcadd6b992e49d1b85140528b29a4
   Deleted: sha256:5271bace0c0be674f3152c32fd316f946360be08aa81b894c137f81d357e6d5e
   Deleted: sha256:81e53d32e9361fbb8e11fc4bdf55bfc38870c2e08827333a781e8bd4c65dc98e
   Deleted: sha256:9eb82f04c782ef3f5ca25911e60d75e441ce0fe82e49f0dbf02c81a3161d1300
   
   C:\Users\Igor>
   ```

   Таблицы нет, потому что это другой контейнер, изолированный от первого контейнера с БД.