# AuditServer

Servidor de métricas, apoyado en la librería Audit4Improve
## Objetivo

El objetivo de este código es practicar con:

* La gestión de dependencias
* La integración continua
* El despliegue continuo

## Dependencias

Este servidor utiliza la api [Audit4Improve](https://github.com/MIT-FS/Audit4Improve-API), en la que los alumnos han trabajado a lo largo de las prácticas de la asignatura

## Desarrollo local

Para ejecutar el servidor web de en la máquina local, ejecuta el siguiente comando:

```shell
./gradlew bootRun
```

Prueba que el servicio expone un endpoint de metricas en /metrics:

```shell
curl http://localhost:8080/metrics
```

El endpoint debe devolver la siguiente respuesta:

```shell
TODO: Utilizar Audit4Improve e imprimir las metricas en la respuesta
```

### Ejecutar los tests

Para ejecutar los tests unitarios, ejecuta el siguiente comando:

```shell
./gradlew test
```

### Desplegar el entorno local de desarrollo

Para el entorno local de desarrollo vamos a usar [Kubernetes] en la
máquina local. Para ello, vamos a necesitar installar previamente
[Kind] y [kubectl]. Una vez instalado comprueba que podemos ejecutar el binario:

```shell
kind --version
```

Para ejecutar el entorno local de desarrollo, ejecuta el siguiente comando:

```shell
./gradlew localenv
```

La tarea `localenv` levanta un cluster de Kubernetes y configura de forma
automática el contexto de Kubernetes para que podamos acceder a la API
de Kubernetes de manera local usando `kubectl`. Levantar el entorno local
debe tardar alrededor de 3 minutos.

Finalmente comprobamos que tenemos acceso al cluster de Kubernetes:

```shell
kubectl get po --all-namespaces
```

Deberemos obtener uns salida similar a la siguiente:

```shell
NAMESPACE            NAME                                                 READY   STATUS    RESTARTS   AGE
kube-system          coredns-558bd4d5db-l8q2g                             1/1     Running   0          83s
kube-system          coredns-558bd4d5db-rqcbm                             1/1     Running   0          84s
kube-system          etcd-audit-server-control-plane                      1/1     Running   0          94s
kube-system          kindnet-glbk7                                        1/1     Running   0          85s
kube-system          kube-apiserver-audit-server-control-plane            1/1     Running   1          94s
kube-system          kube-controller-manager-audit-server-control-plane   1/1     Running   0          94s
kube-system          kube-proxy-db56r                                     1/1     Running   0          85s
kube-system          kube-scheduler-audit-server-control-plane            1/1     Running   0          94s
local-path-storage   local-path-provisioner-547f784dff-vz7c2              1/1     Running   0          83s
```

Cuando hayamos terminado, simplemente borramos el cluster:

```shell
./gradlew clean
```

[Kubernetes]: https://kubernetes.io/
[Kind]: https://kind.sigs.k8s.io/docs/user/quick-start#installation
[kubectl]: https://kubernetes.io/docs/tasks/tools/#kubectl

## Comenzar con Spring Boot para el desarrollo de servicios REST

Enlaces generados automáticamente al crear el esqueleto del servicio en [start.spring.io](https://start.spring.io/)

### Documentación de referencia

For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.6.7/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.6.7/gradle-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.6.7/reference/htmlsingle/#boot-features-developing-web-applications)

### Guías

The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

### Enlaces adicionales

These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)