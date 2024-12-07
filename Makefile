# Make all md files into html
SRCFILES:= $(wildcard *.md)
DESTFILES:= $(patsubst %.md,%.html,$(SRCFILES))
all: quantum.html

dontwantreadme: $(DESTFILES)

clean:
	rm -f $(DESTFILES)

%.html: %.md prefix.htx postfix.htx; cat prefix.htx  $<  postfix.htx > $@
