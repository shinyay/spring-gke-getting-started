# Spring Boot on GKE Getting Started

Overview

## Description

## Demo

### Prerequisite
#### Google Cloud SDK
- [For MaxOS](https://cloud.google.com/sdk/docs/quickstart-macos?hl=ja)

```
$ ./google-cloud-sdk/install.sh
```

#### GCP Login
```
$ gcloud auth login --project PROJECT_ID
```

#### Enabled GCP Service List
```
$ gcloud services list
```
```
NAME                                 TITLE
bigquery.googleapis.com              BigQuery API
bigquery.googleapis.com              BigQuery API
bigquerystorage.googleapis.com       BigQuery Storage API
bigtable.googleapis.com              Cloud Bigtable API
bigtableadmin.googleapis.com         Cloud Bigtable Admin API
cloudapis.googleapis.com             Google Cloud APIs
cloudbilling.googleapis.com          Cloud Billing API
clouddebugger.googleapis.com         Stackdriver Debugger API
cloudkms.googleapis.com              Cloud Key Management Service (KMS) API
cloudresourcemanager.googleapis.com  Cloud Resource Manager API
cloudtrace.googleapis.com            Stackdriver Trace API
compute.googleapis.com               Compute Engine API
container.googleapis.com             Kubernetes Engine API
containerregistry.googleapis.com     Container Registry API
datastore.googleapis.com             Cloud Datastore API
deploymentmanager.googleapis.com     Cloud Deployment Manager V2 API
dns.googleapis.com                   Cloud DNS API
file.googleapis.com                  Cloud Filestore API
firebaserules.googleapis.com         Firebase Rules API
firestore.googleapis.com             Cloud Firestore API
iam.googleapis.com                   Identity and Access Management (IAM) API
iamcredentials.googleapis.com        IAM Service Account Credentials API
iap.googleapis.com                   Cloud Identity-Aware Proxy API
logging.googleapis.com               Stackdriver Logging API
monitoring.googleapis.com            Stackdriver Monitoring API
oslogin.googleapis.com               Cloud OS Login API
pubsub.googleapis.com                Cloud Pub/Sub API
redis.googleapis.com                 Google Cloud Memorystore for Redis API
replicapool.googleapis.com           Compute Engine Instance Group Manager API
replicapoolupdater.googleapis.com    Compute Engine Instance Group Updater API
resourceviews.googleapis.com         Compute Engine Instance Groups API
servicemanagement.googleapis.com     Service Management API
serviceusage.googleapis.com          Service Usage API
sql-component.googleapis.com         Cloud SQL
sqladmin.googleapis.com              Cloud SQL Admin API
storage-api.googleapis.com           Google Cloud Storage JSON API
storage-component.googleapis.com     Cloud Storage
```

If `Container Registry API` and `Kubernetes Engine API` is not enabled, execute the following command;
```
$ gcloud services enable containerregistry.googleapis.com
$ gcloud services enable compute.googleapis.com container.googleapis.com
```

#### Jib to Build Container

- build.gradle.kts
```
import com.google.cloud.tools.jib.gradle.JibExtension
  :
  :
plugins {
  id ("com.google.cloud.tools.jib") version "1.8.0"
}
  :
  :
val project_id = if (hasProperty("project_id")) findProperty("project_id") as String else ""
jib.from.image = "shinyay/adoptopenjdk11-minimum"
jib.to.image = "gcr.io/${project_id}/spring-gs:v1"
jib.container.jvmFlags = mutableListOf("-Xms512m", "-Xdebug")
jib.container.useCurrentTimestamp = true
```

- gradle.properties
```
project_id=GCP_PROJECT_ID
```

```
$ gradlew clean jib
```

```
$ gcloud container images list
```

#### Run Container App from GCR
```
$ docker run --rm -it -p 8080:8080 gcr.io/<GCP_PROJECT_ID>/spring-gs:v1
```

#### Ceate GKE Cluster
`Usage: gcloud container clusters create NAME [optional flags]`

```
$ gcloud container clusters create spring-gs-cluster \
  --num-nodes 2 \
  --machine-type n1-standard-1 \
  --zone us-central1-c
```

##### Create Cluster Options

```
  optional flags may be  --accelerator | --additional-zones | --addons |
                         --async | --autoprovisioning-config-file |
                         --autoprovisioning-locations |
                         --autoprovisioning-scopes |
                         --autoprovisioning-service-account |
                         --cluster-ipv4-cidr | --cluster-secondary-range-name |
                         --cluster-version | --create-subnetwork |
                         --database-encryption-key |
                         --default-max-pods-per-node | --disk-size |
                         --disk-type | --enable-autoprovisioning |
                         --enable-autorepair | --enable-autoscaling |
                         --enable-autoupgrade | --enable-basic-auth |
                         --enable-binauthz | --enable-cloud-logging |
                         --enable-cloud-monitoring | --enable-cloud-run-alpha |
                         --enable-intra-node-visibility | --enable-ip-alias |
                         --enable-kubernetes-alpha |
                         --enable-legacy-authorization |
                         --enable-master-authorized-networks |
                         --enable-network-egress-metering |
                         --enable-network-policy | --enable-private-endpoint |
                         --enable-private-nodes |
                         --enable-resource-consumption-metering |
                         --enable-stackdriver-kubernetes | --enable-tpu |
                         --enable-vertical-pod-autoscaling | --help |
                         --image-type | --issue-client-certificate | --labels |
                         --local-ssd-count | --machine-type |
                         --maintenance-window | --maintenance-window-end |
                         --maintenance-window-recurrence |
                         --maintenance-window-start |
                         --master-authorized-networks | --master-ipv4-cidr |
                         --max-accelerator | --max-cpu | --max-memory |
                         --max-nodes | --max-nodes-per-pool |
                         --max-pods-per-node | --metadata |
                         --metadata-from-file | --min-accelerator | --min-cpu |
                         --min-cpu-platform | --min-memory | --min-nodes |
                         --network | --node-labels | --node-locations |
                         --node-taints | --node-version | --num-nodes |
                         --password | --preemptible | --region | --reservation |
                         --reservation-affinity |
                         --resource-usage-bigquery-dataset | --scopes |
                         --service-account | --services-ipv4-cidr |
                         --services-secondary-range-name |
                         --shielded-integrity-monitoring |
                         --shielded-secure-boot | --subnetwork | --tags |
                         --tpu-ipv4-cidr | --username | --zone
```

#### List GKE Clusters
```
$ gcloud container clusters list

NAME               LOCATION       MASTER_VERSION  MASTER_IP       MACHINE_TYPE   NODE_VERSION    NUM_NODES  STATUS
spring-gs-cluster  us-central1-c  1.13.11-gke.14  ...........
```

#### Deploy Application on GKE
```
$ kubectl config get-contexts

CURRENT   NAME                                                 CLUSTER                                              AUTHINFO                                             NAMESPACE
*         gke_.........
```

## Features

- feature:1
- feature:2

## Requirement

## Usage

## Installation

## Licence

Released under the [MIT license](https://gist.githubusercontent.com/shinyay/56e54ee4c0e22db8211e05e70a63247e/raw/34c6fdd50d54aa8e23560c296424aeb61599aa71/LICENSE)

## Author

[shinyay](https://github.com/shinyay)
