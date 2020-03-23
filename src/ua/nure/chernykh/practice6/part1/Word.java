package ua.nure.chernykh.practice6.part1;

public class Word implements Comparable<Word> {

    private String content;
    private int frequency;

    public Word(String word) {
        this.content = word;
        this.frequency = 1;
    }

    public String getContent() {
        return content;
    }

    public int getFrequency() {
        return frequency;
    }

    public void incFrequency() {
        this.frequency++;
    }

    @Override
    public int compareTo(Word word) {
        if (word.getFrequency() == this.frequency) {
            return this.content.compareTo(word.getContent());
        }
        return (word.getFrequency() - this.frequency);
    }

    @Override
    public int hashCode() {
        return content.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass().equals(this.getClass())) {
            return content.equals(((Word) obj).content);
        }
        return false;
    }

    @Override
    public String toString() {
        return content;
    }
}
