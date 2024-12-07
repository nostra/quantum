///usr/bin/env java --source 23 --enable-preview  "$0" "$@"; exit $?
///usr/bin/env /usr/lib/jvm/java-23-openjdk-23.0.1.0.11-1.rolling.fc41.x86_64/bin/java --source 23 --enable-preview  "$0" "$@"; exit $?

// Module import example:
import module java.desktop;

// How to get classpath out of a maven project
// mvn -q exec:exec -Dexec.executable=echo -Dexec.args="%classpath"

// Idea: Construct prompt from script
// Idea: Duplicate script from https://husbanken.atlassian.net/wiki/spaces/ENV/pages/46436714/Oppgradering+av+Istio+Control+Plane
// https://github.com/fabric8io/kubernetes-client/blob/main/kubernetes-examples/src/main/java/io/fabric8/kubernetes/examples/kubectl/equivalents/RolloutRestartEquivalent.java

// Check: What would be the main difference if using jshell?
// jshell --class-path $(mvn -q exec:exec -Dexec.executable=echo -Dexec.args="%classpath")

// https://www.redpill-linpro.com/techblog/2024/02/21/java-21-shell-scripts.html
void main() {
    System.out.println("Hello, World!");
    JFileChooser jfc= new JFileChooser();
    JDialog parent = new JDialog();
    parent.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    jfc.showOpenDialog(parent);
    System.out.println(jfc.getSelectedFile());
    System.exit(0);
}
