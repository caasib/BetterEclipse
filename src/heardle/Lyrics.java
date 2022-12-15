/**
 * Author: Caasi Boakye
 * Date:   Nov 3, 2022
 * Description: 
 */
package heardle;
import java.util.Random;
import java.util.Scanner;

/**
 * @author studentgvsc
 *
 */
public class Lyrics {
	public static String[] lyrics = {"I hallucinate when you call my name\r\n"
	+ "Got stars in my eyes\r\n"
	+ "And they don't fade when you come my way", 
			
	"Lights out, follow the noise\r\n"
	+ "Baby, keep on dancing like you ain't got a choice\r\n"
	+ "So come on (Come on), come on (Come on), come on\r\n"
	+ "Let's get physical", 
					
	"Don't show up, don't come out\r\n"
	+ "Don't start caring about me now\r\n"
	+ "Walk away, you know how\r\n"
	+ "Don't start caring about me now",
	
	"You make my desire pure, you make my desire pure\r\n"
	+ "Just tell me what to say, I can't find the words to say\r\n"
	+ "Please don't be mad with me, I have no identity\r\n"
	+ "All that I've known is gone, all I was building on\r\n"
	+ "I wanna walk with you, how do I talk to you",
			
	"Guys, you know you'd better watch out\r\n"
	+ "Some girls, some girls are only about\r\n"
	+ "That thing, that thing, that thing\r\n"
	+ "That thing, that thing, that thing", 
	
	"You might win some but you just lost one", 
	
	"She got a light-skinned friend look like Michael Jackson\r\n"
	+ "Got a dark-skinned friend look like Michael Jackson", 
	
	"If you follow my instructions, you’ll be able to date a rapper, an NBA player, or at least a dude with a car",
	
	"I'm comin' home again\r\n"
	+ "Do you think about me now and then?\r\n"
	+ "Do you think about me now and then?",
	
	"The dog days are over\r\n"
	+ "The dog days are done\r\n"
	+ "The horses are coming\r\n"
	+ "So you better run\r\n",
	
	"And I am done with my graceless heart\r\n"
	+ "So tonight, I'm gonna cut it out and then restart\r\n"
	+ "'Cause I like to keep my issues drawn\r\n"
	+ "It's always darkest before the dawn",
	
	"A falling star fell from your heart and landed in my eyes\r\n"
	+ "I screamed aloud, as it tore through them\r\n"
	+ "And now it's left me blind",
	
	"I don't want a lot for Christmas\r\n"
	+ "There is just one thing I need\r\n"
	+ "I don't care about the presents\r\n"
	+ "Underneath the Christmas tree\r\n"
	+ "I just want you for my own\r\n"
	+ "More than you could ever know\r\n"
	+ "Make my wish come true\r\n"
	+ "All I want for Christmas is you, yeah",
	
	"But you in LA, and I'm out at Jermaine's\r\n"
	+ "I'm up in the A, you so, so lame\r\n"
	+ "And no one here even mentions your name",
	
	"Bobby Womack's on the radio\r\n"
	+ "Singing to me, \"If you think you're lonely now\"",
	
	"I just want you to know how I feel (How I feel)\r\n"
	+ "Feeling good, feeling great\r\n"
	+ "How I feel, oh, I\r\n"
	+ "Feeling great, feeling good, how are you, you?\r\n"
	+ "I just want you to know how I feel\r\n"
	+ "Feeling good, feeling great\r\n"
	+ "How I feel\r\n"
	+ "Feeling great, feeling good, how are you?",
	
	"A lil' spot where young men and young women go to experience they first little taste of the night life\r\n"
	+ "Me? Well, I've never been there\r\n"
	+ "Well, perhaps, once, but I was so engulfed in the Ol' E', I never made it to the door", 
	
	"Now is the time to get on—like Spike Lee said, \"Get on the Bus\"\r\n"
	+ "Go get your work and keep your beeper chirping—it's a must\r\n"
	+ "Is you on that dust or corn starch? Familiar with that smack, man?\r\n"
	+ "The music is like that green stuff provided to you by sack-man\r\n"
	+ "Pacman", 
	
	"Ooh, I'm up in Brownsville, strapped with a Kimber\r\n"
	+"All you yuppie purses getting swiped like Tinder\r\n"
	+ "Now I'm at the White House, looking for your President\r\n"
	+ "Hop out the van, pointing guns at your residence", 
	
	"I feel annoyed (Feel annoyed)\r\n"
	+ "I'm feelin' strange, I feel the gains, I fill a void (Void)\r\n"
	+ "I'm still a roach, I'm doin' shows, I feel employed (Feel employed)\r\n"
	+ "Even though I'm coy (Though I'm coy), and you know that, boy", 
	
	"Shuttlesworth blessed me with talent\r\n"
	+ "Hairline proof God needs balance\r\n"
	+ "Bald",
	
	"No, I don't want no scrub\r\n"
	+ "A scrub is a guy that can't get no love from me\r\n"
	+ "Hangin' out the passenger side of his best friend's ride\r\n"
	+ "Trying to holla at me",
	
	"Don't go chasing waterfalls\r\n"
	+ "Please stick to the rivers and the lakes that you're used to\r\n"
	+ "I know that you're gonna have it your way or nothing at all\r\n"
	+ "But I think you're moving too fast\r\n",
	
	"So I creep, yeah, just keep it on the down low\r\n"
	+ "Said nobody is supposed to know\r\n"
	+ "So I creep, yeah, cause he doesn't know what I do\r\n"
	+ "And no attention goes to show, oh so I creep\r\n",
	
	"Woke up this morning\r\n"
	+ "I couldn't find my face\r\n"
	+ "Guess you finally got your way\r\n"
	+ "\r\n"
	+ "You said that you don't wanna see me\r\n"
	+ "You wish that I didn't breathe\r\n"
	+ "Don't wanna hear what I've got to say\r\n"
	+ "Just wanna up and leave",
	
	"I found myself in the city\r\n"
	+ "In the 'Miss Pretty' lights\r\n"
	+ "And I told my friends I was waiting on a train\r\n"
	+ "But the truth is I don't know where I slept last night\r\n"
	+ "",
	
	"I don't need clarity\r\n"
	+ "Keep, all of your daydreams\r\n"
	+ "Of, frivolous wants and things\r\n"
	+ "That everyone wants\r\n"
	+ "And I would tell you, to go to hell\r\n"
	+ "If I could find the words to people like\r\n"
	+ "\r\n"
	+ "I've tried to kill the pain\r\n"
	+ "And, a thousand ways before\r\n"
	+ "I, realised there was nothing\r\n"
	+ "I needed to kill\r\n"
	+ "And so I'll say, that it's all fine\r\n"
	+ "That it's all fine",
	
	"That's why I need a one dance\r\n"
	+ "Got a Hennessy in my hand\r\n"
	+ "One more time 'fore I go\r\n"
	+ "Higher powers taking a hold on me\r\n"
	+ "I need a one dance\r\n"
	+ "Got a Hennessy in my hand\r\n"
	+ "One more time 'fore I go\r\n"
	+ "Higher powers taking a hold on me",
	
	"Runnin' through the 6 with my woes\r\n"
	+ "Countin' money, you know how it goes\r\n"
	+ "Pray the real live forever, man\r\n"
	+ "Pray the fakes get exposed\r\n"
	+ "I want that Ferrari, then I swerve\r\n"
	+ "I want that Bugatti, just to hurt\r\n"
	+ "I ain't rockin' my jewelry, that's on purpose",
	
	"Sittin' Gucci Row like they say up at UNLV\r\n"
	+ "Young rebel, Young Money, nothin' you could tell me\r\n"
	+ "Paperwork takin' too long, maybe they don't understand me\r\n"
	+ "I'll compromise if I have to, I gotta stay with the family\r\n"
	+ "Not even talkin' to Nicki, communication is breakin'\r\n"
	+ "I dropped the ball on some personal shit, I need to embrace it",
	
	"Pretty little bird\r\n"
	+ "Pretty little bird\r\n"
	+ "You've hit the window a few times\r\n"
	+ "The window a few times\r\n"
	+ "You're pretty little bird\r\n"
	+ "Pretty little bird\r\n"
	+ "You still ain't scared of no heights\r\n"
	+ "When the spiral down feels as good as the flight\r\n"
	+ "When hating you feels good for the night\r\n"
	+ "When the morning comes I hope you're still mine\r\n"
	+ "",
	
	"My man is my man, is your man, heard it's her man too\r\n"
	+ "My man is my man, is your man, heard that's her man\r\n"
	+ "Tuesday and Wednesday, Thursday and Friday\r\n"
	+ "I just keep him satisfied through the weekend\r\n"
	+ "You like 9 to 5, I'm the weekend, oh-oh\r\n"
	+ "Make him lose his mind every weekend\r\n"
	+ "You take Wednesday, Thursday, then just send him my way\r\n"
	+ "Think I got it covered for the weekend",
	
	"Why you bother me? Why you bother me? Why you bother me? (Why you bother me? Yeah)\r\n"
	+ "Last time I checked, you were the one that left (The one)\r\n"
	+ "Me in a wreck (Yeah), me in a mess (Yeah, yeah)\r\n"
	+ "You all I rep (Yeah), like my side I rep (Yeah)\r\n"
	+ "Yeah, that's that Mo City that side, that you can't come 'round at night, yeah (It's lit)"
	};
	
	private Random rand = new Random();
	private String lyric = "";
	private int lyricsIndex = rand.nextInt(lyrics.length);

	public Lyrics() {
		lyric = Lyrics.lyrics[lyricsIndex];
	}
	
	public String getLyrics() {
		return lyric;
	}

	public String getSong() {
		return Songs.songs[lyricsIndex];
	}
	
}

