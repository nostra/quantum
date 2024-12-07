///usr/bin/env java --source 23 --enable-preview  "$0" "$@"; exit $?
///usr/bin/env /usr/lib/jvm/java-23-openjdk-23.0.1.0.11-1.rolling.fc41.x86_64/bin/java --source 23 --enable-preview  "$0" "$@"; exit $?
import io.fabric8.kubernetes.client.KubernetesClientBuilder;

void main(String[] args) {
    try (var client = new KubernetesClientBuilder().build()) {
        System.out.println("Getting pods...");
        client.pods()
                .list()
                .getItems()
                .stream()
                .map(pod -> pod.getMetadata().getName())
                .forEach(System.out::println);
    }
    System.out.println("Finished");
}
