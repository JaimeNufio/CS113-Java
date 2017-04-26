public class instrument {

    public static void main(java.lang.String[] args) {

        Instrument[] orchestra = {new Drum(), new Flute(), new Guitar(), new Trumpet(), new Violin()};

        for (Instrument i : orchestra) {
            i.tune();
            i.play();
        }
    }
}

interface Instrument {

    void play();
    void tune();
}

abstract class Brass implements Instrument {

    public void tune() {
        System.out.println("tune " + getClass().getName());
    }
}

abstract class Percussion implements Instrument {

    public void tune() {
        System.out.println("tune " + getClass().getName());
    }
}

abstract class String implements Instrument {

    public void tune() {
        System.out.println("tune " + getClass().getName());
    }
}

abstract class Wind implements Instrument {

    public void tune() {
        System.out.println("tune " + getClass().getName());
    }
}

class Drum extends Percussion {

    public void play() {
        System.out.println("play " + getClass().getName());
    }
}

class Flute extends Wind {

    public void play() {
        System.out.println("play " + getClass().getName());
    }
}

class Guitar extends String {

    public void play() {
        System.out.println("play " + getClass().getName());
    }
}

class Trumpet extends Brass {

    public void play() {
        System.out.println("play " + getClass().getName());
    }
}

class Violin extends String {

    public void play() {
        System.out.println("play " + getClass().getName());
    }
}
