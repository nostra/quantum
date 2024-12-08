///usr/bin/env java --source 23 --enable-preview  "$0" "$@"; exit $?
///usr/bin/env /usr/lib/jvm/java-23-openjdk-23.0.1.0.11-1.rolling.fc41.x86_64/bin/java --source 23 --enable-preview  "$0" "$@"; exit $?

import module java.desktop;

void main() {
    JFileChooser jfc= new JFileChooser();
    JDialog parent = new JDialog();
    parent.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    jfc.showOpenDialog(parent);
    System.out.println(jfc.getSelectedFile());
    System.exit(0);
}
