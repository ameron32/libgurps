package com.ameron32.libcharacter.library;

import java.util.HashMap;

import com.ameron32.libgurps.impl.GURPSObject;

public class PersonalityTraits extends GURPSObject {
	private static final long serialVersionUID = 608799372534638266L;
	// TODO verify PersonalityTraits import correctly

	public static final int ID = 0;
	public static final int NAME = 1;
	public static final int DESCRIPTION = 2;
	
    private final HashMap<String, PersonalityTrait> personalityTraits = new HashMap<String, PersonalityTrait>();
    
    /* REPLACED v2 
    private String[][] personalityTraitsO = {
            {
                    "Able",
                    "Able - adj. (usually followed by `to') having the necessary means or skill or know-how or authority to do something; having inherent physical or mental ability or capacity; have the skills and qualifications to do things well; having a strong healthy body"
            },
            {
                    "Absent-minded", "Absentminded - adj. lost in thought; showing preoccupation"
            },
            {
                    "Active",
                    "Active - adj. characterized by energetic activity; engaged in full-time work; full of activity or engaged in continuous activity; tending to become more severe or wider in scope; disposed to take action or effectuate change; (of e.g. volcanos) erupting or liable to erupt; (of e.g. volcanos) capable of erupting; expressing action rather than a state of being; used of verbs (e.g. `to run') and participial adjectives (e.g. `running' in `running water'); expressing that the subject of the sentence has the semantic function of actor: ''Hemingway favors active constructions''; exerting influence or producing a change or effect; of the sun; characterized by a high level activity in sunspots and flares and radio emissions; in operation; taking part in an activity; engaged in or ready for military or naval operations; noun a person devoted to the active life; the voice used to indicate that the grammatical subject of the verb is performing the action or causing the happening denoted by the verb; chemical agent capable of activity"
            },
            {
                    "Adventurous",
                    "Adventurous - adj. willing to undertake or seeking out new and daring enterprises"
            },
            {
                    "Affable", "Affable - adj. diffusing warmth and friendliness"
            },
            {
                    "Affected",
                    "Affected - adj. acted upon; influenced; speaking or behaving in an artificial way to make an impression; being excited or provoked to the expression of an emotion"
            },
            {
                    "Affectionate", "Affectionate - adj. having or displaying warmth or affection"
            },
            {
                    "Afraid",
                    "Afraid - adj. filled with fear or apprehension; filled with regret or concern; used often to soften an unpleasant statement; feeling worry or concern or insecurity; having feelings of aversion or unwillingness"
            },
            {
                    "Aggressive",
                    "Aggressive - adj. having or showing determination and energetic pursuit of your ends; characteristic of an enemy or one eager to fight; tending to spread quickly"
            },
            {
                    "Alert",
                    "Alert - adj. very attentive or observant; (usually followed by `to') showing acute awareness; mentally perceptive; not unconscious; especially having become conscious; mentally responsive; noun a warning serves to make you more alert to danger; condition of heightened watchfulness or preparation for action; an automatic signal (usually a sound) warning of danger; verb warn or arouse to a sense of danger or call to a state of preparedness"
            },
            {
                    "Ambitious",
                    "Ambitious - adj. having a strong desire for success or achievement; requiring full use of your abilities or resources"
            },
            {
                    "Amiable",
                    "Amiable - adj. disposed to please; diffusing warmth and friendliness"
            },
            {
                    "Angry",
                    "Angry - adj. feeling or showing anger; (of the elements) as if showing violent anger; severely inflamed and painful"
            },
            {
                    "Animated",
                    "Animated - adj. having life or vigor or spirit; made to appear to move as living creatures do"
            },
            {
                    "Annoyed",
                    "Annoyed - adj. aroused to impatience or anger; troubled persistently especially with petty annoyances"
            },
            {
                    "Anxious",
                    "Anxious - adj. eagerly desirous; causing or fraught with or showing anxiety"
            },
            {
                    "apologetic", "apologetic - adj. offering or expressing apology"
            },
            {
                    "Appreciative",
                    "Appreciative - adj. having or showing appreciation or a favorable critical judgment or opinion; feeling or expressive of gratitude"
            },
            {
                    "Argumentative", "Argumentative - adj. given to or characterized by argument"
            },
            {
                    "Arrogant",
                    "Arrogant - adj. having or showing feelings of unwarranted importance out of overbearing pride"
            },
            {
                    "Attentive",
                    "Attentive - adj. (often followed by `to') giving care or attention;taking heed; giving close and thoughtful attention"
            },
            {
                    "Austere",
                    "Austere - adj. of a stern or strict bearing or demeanor; forbidding in aspect; severely simple; practicing great self-denial"
            },
            {
                    "Average",
                    "Average - adj. lacking special distinction, rank, or status; commonly encountered; around the middle of a scale of evaluation of physical measures; approximating the statistical norm or average or expected value; lacking exceptional quality or ability;relating to or constituting the middle value of an ordered set of values (or the average of the middle two in a set with an even number of values); relating to or constituting the most frequent value in a distribution; noun a statistic describing the location of a distribution; verb compute the average of; achieve or reach on average; amount to or come to an average, without loss or gain"
            },
            {
                    "Awkward",
                    "Awkward - adj. not at ease socially; unsure and constrained in manner; causing inconvenience; hard to deal with; especially causing pain or embarrassment; not elegant or graceful in expression; lacking grace or skill in manner or movement or performance; difficult to handle or manage especially because of shape"
            },
            {
                    "Babyish", "Babyish - adj. characteristic of a baby"
            },
            {
                    "Bad",
                    "Bad - adj. feeling physical discomfort or pain (`tough' is occasionally used colloquially for `bad'); (of foodstuffs) not in an edible or usable condition; not working properly; reproduced fraudulently; having undesirable or negative qualities;characterized by wickedness or immorality; capable of harming;physically unsound or diseased; very intense; not financially safe or secure; nonstandard; below average in quality or performance;not capable of being collected; feeling or expressing regret or sorrow or a sense of loss over something done or undone; adv.very much; strongly; with great intensity (`bad' is a nonstandard variant for `badly'); noun that which is below standard or expectations as of ethics or decency"
            },
            {
                    "Bashful", "Bashful - adj. disposed to avoid notice; self-consciously timid"
            },
            {
                    "Bewildered",
                    "Bewildered - adj. perplexed by many conflicting situations or statements; filled with bewilderment"
            },
            {
                    "Blasé",
                    "Blase - adj. nonchalantly unconcerned; uninterested because of frequent exposure or indulgence; very sophisticated especially because of surfeit; versed in the ways of the world"
            },
            {
                    "Blowhard", "Blowhard - noun a very boastful and talkative person"
            },
            {
                    "Boastful", "Boastful - adj. exhibiting self-importance"
            },
            {
                    "Bold",
                    "Bold - adj. fearless and daring; clear and distinct; very steep; having a prominent and almost vertical front; noun a typeface with thick heavy lines"
            },
            {
                    "Boorish",
                    "Boorish - adj. ill-mannered and coarse and contemptible in behavior or appearance"
            },
            {
                    "Bored",
                    "Bored - adj. tired of the world; uninterested because of frequent exposure or indulgence"
            },
            {
                    "Bossy",
                    "Bossy - adj. offensively self-assured or given to exercising usually unwarranted power"
            },
            {
                    "Brainy",
                    "Brainy - adj. having or marked by unusual and impressive intelligence"
            },
            {
                    "Brave",
                    "Brave - adj. possessing or displaying courage; able to face and deal with danger or fear without flinching; brightly colored and showy; invulnerable to fear or intimidation; noun people who are brave; a North American Indian warrior; verb face or endure with courage"
            },
            {
                    "Bright",
                    "Bright - adj. full or promise; having lots of light either natural or artificial; emitting or reflecting light readily or in large amounts;having striking color; abounding with sunlight; splendid;characterized by happiness or gladness; characterized by quickness and ease in learning; made smooth and bright by or as if by rubbing; reflecting a sheen or glow; clear and sharp and ringing; not made dim or less bright; adv. with brightness"
            },
            {
                    "Brilliant",
                    "Brilliant - adj. full of light; shining intensely; characterized by grandeur; of surpassing excellence; having striking color; having or marked by unusual and impressive intelligence; clear and sharp and ringing"
            },
            {
                    "Brutish",
                    "Brutish - adj. resembling a beast; showing lack of human sensibility"
            },
            {
                    "Busy",
                    "Busy - adj. crowded with or characterized by much activity; actively or fully engaged or occupied; (of facilities such as telephones or lavatories) unavailable for use by anyone else or indicating unavailability; (`engaged' is a British term for a busy telephone line); overcrowded or cluttered with detail; intrusive in a meddling or offensive manner; verb keep busy with"
            },
            {
                    "Calm",
                    "Calm - adj. (of weather) free from storm or wind; not agitated; without losing self-possession; living without undue worry; taking life easy; noun steadiness of mind under stress; verb become quiet or calm, especially after a state of agitation; make calm or still; cause to be calm or quiet as by administering a sedative to;make steady"
            },
            {
                    "Candid",
                    "Candid - adj. openly straightforward and direct without reserve or secretiveness; informal or natural; especially caught off guard or unprepared; characterized by directness in manner or speech; without subtlety or evasion"
            },
            {
                    "Capable",
                    "Capable - adj. (usually followed by `of') having capacity or ability;(followed by `of') having the temperament or inclination for;possibly accepting or permitting; having the requisite qualities for;have the skills and qualifications to do things well"
            },
            {
                    "Carefree",
                    "Carefree - adj. cheerfully irresponsible; free of trouble and worry and care"
            },
            {
                    "Careful",
                    "Careful - adj. exercising caution or showing care or attention; with care and dignity; mindful of the future in spending money;cautiously attentive; full of cares or anxiety"
            },
            {
                    "Careless",
                    "Careless - adj. effortless and unstudied; marked by lack of attention or consideration or forethought or thoroughness; not careful; (usually followed by `of') without due thought or consideration"
            },
            {
                    "caring",
                    "caring - adj. feeling and exhibiting concern and empathy for others;showing a care; having or displaying warmth or affection; noun a loving feeling"
            },
            {
                    "Caustic",
                    "Caustic - adj. of a substance, especially a strong acid; capable of destroying or eating away by chemical action; harsh or corrosive in tone; noun any chemical substance that burns or destroys living tissue"
            },
            {
                    "Cautious",
                    "Cautious - adj. cautious in attitude and careful in actions; prudent;showing careful forethought; avoiding excess; noun people who are fearful and cautious"
            },
            {
                    "Changeable",
                    "Changeable - adj. such that alteration is possible; having a marked tendency to change; varying in color when seen in different lights or from different angles; subject to change; capable of or tending to change in form or quality or nature"
            },
            {
                    "Charismatic",
                    "Charismatic - adj. possessing an extraordinary ability to attract"
            },
            {
                    "Charming",
                    "Charming - adj. possessing or using or characteristic of or appropriate to supernatural powers; pleasing or delighting"
            },
            {
                    "Cheerful",
                    "Cheerful - adj. being full of or promoting cheer; having or showing good spirits; pleasantly (even unrealistically) optimistic"
            },
            {
                    "Civilised",
                    "Civilised - adj. having a high state of culture and development both social and technological; marked by refinement in taste and manners"
            },
            {
                    "Clever",
                    "Clever - adj. showing inventiveness and skill; skillful (or showing skill) in adapting means to ends; showing self-interest and shrewdness in dealing with others; mentally quick and resourceful"
            },
            {
                    "Clumsy",
                    "Clumsy - adj. not elegant or graceful in expression; lacking grace in movement or posture; showing lack of skill or aptitude; difficult to handle or manage especially because of shape"
            },
            {
                    "Coarse",
                    "Coarse - adj. conspicuously and tastelessly indecent; lacking refinement or cultivation or taste; of textures that are rough to the touch or substances consisting of relatively large particles; of low or inferior quality or value"
            },
            {
                    "Cold-hearted", "Coldhearted - adj. lacking in sympathy or feeling"
            },
            {
                    "Commitment-phobe", ""
            },
            {
                    "Committed",
                    "Committed - adj. bound or obligated, as under a pledge to a particular cause, action, or attitude; associated in an exclusive sexual relationship"
            },
            {
                    "Communicative",
                    "Communicative - adj. able or tending to communicate; of or relating to communication"
            },
            {
                    "compassionate",
                    "compassionate - adj. showing or having compassion; showing merciful compassion; verb share the suffering of"
            },
            {
                    "Competent",
                    "Competent - adj. adequate for the purpose; properly or sufficiently qualified or capable or efficient"
            },
            {
                    "Complacent",
                    "Complacent - adj. contented to a fault with oneself or one's actions"
            },
            {
                    "Conceited",
                    "Conceited - adj. characteristic of false pride; having an exaggerated sense of self-importance"
            },
            {
                    "Concerned",
                    "Concerned - adj. feeling or showing worry or solicitude; involved in or affected by or having a claim to or share in; in relation (or in regard) to; especially as in the phrases; culpably involved"
            },
            {
                    "Confident",
                    "Confident - adj. not liable to error in judgment or action; having or marked by confidence or assurance; persuaded of; very sure"
            },
            {
                    "Confused",
                    "Confused - adj. mentally confused; unable to think with clarity or act intelligently; lacking orderly continuity; having lost your bearings; confused as to time or place or personal identity; thrown into a state of disarray or confusion; perplexed by many conflicting situations or statements; filled with bewilderment"
            },
            {
                    "Conscientious",
                    "Conscientious - adj. characterized by extreme care and great effort;guided by or in accordance with conscience or sense of right and wrong"
            },
            {
                    "Considerate",
                    "Considerate - adj. showing concern for the rights and feelings of others"
            },
            {
                    "Consistent",
                    "Consistent - adj. (sometimes followed by `with') in agreement or consistent or reliable; the same throughout in structure or composition; marked by an orderly, logical, and aesthetically consistent relation of parts; capable of being reproduced"
            },
            {
                    "Contented",
                    "Contented - adj. satisfied or showing satisfaction with things as they are"
            },
            {
                    "Cooperative",
                    "Cooperative - adj. done with or working with others for a common purpose or benefit; willing to adjust to differences in order to obtain agreement; involving the joint activity of two or more; noun a jointly owned commercial enterprise (usually organized by farmers or consumers) that produces and distributes goods and services and is run for the benefit of its owners; an association formed and operated for the benefit of those using it"
            },
            {
                    "Courageous",
                    "Courageous - adj. possessing or displaying courage; able to face and deal with danger or fear without flinching"
            },
            {
                    "Cowardly", "Cowardly - adj. lacking courage; ignobly timid and faint-hearted"
            },
            {
                    "Crafty", "Crafty - adj. marked by skill in deception"
            },
            {
                    "Creative",
                    "Creative - adj. promoting construction or creation; having the ability or power to create"
            },
            {
                    "Critical",
                    "Critical - adj. marked by a tendency to find and call attention to errors and flaws; characterized by careful evaluation and judgment;being in or verging on a state of crisis or emergency; at or of a point at which a property or phenomenon suffers an abrupt change especially having enough mass to sustain a chain reaction;forming or having the nature of a turning point or crisis; urgently needed; absolutely necessary; of or involving or characteristic of critics or criticism"
            },
            {
                    "Cross",
                    "Cross - adj. extending or lying across; in a crosswise direction; at right angles to the long axis; perversely irritable; noun a representation of the structure on which Jesus was crucified; used as an emblem of Christianity or in heraldry; a wooden structure consisting of an upright post with a transverse piece; any affliction that causes great suffering; (genetics) the act of mixing different species or varieties of animals or plants and thus to produce hybrids; an organism that is the offspring of genetically dissimilar parents or stock; especially offspring produced by breeding plants or animals of different varieties or breeds or species; a marking that consists of lines that cross each other; verb trace a line through or across; meet and pass; fold so as to resemble a cross;to cover or extend over an area or time period; breed animals or plants using parents of different races and varieties; travel across or pass over; meet at a point; hinder or prevent (the efforts, plans, or desires) of"
            },
            {
                    "Cruel",
                    "Cruel - adj. (of persons or their actions) able or disposed to inflict pain or suffering; (of weapons or instruments) causing suffering and pain"
            },
            {
                    "Cultured", "Cultured - adj. marked by refinement in taste and manners"
            },
            {
                    "Curious",
                    "Curious - adj. eager to investigate and learn or learn more (sometimes about others' concerns); beyond or deviating from the usual or expected; having curiosity aroused; eagerly interested in learning more"
            },
            {
                    "Dainty",
                    "Dainty - adj. delicately beautiful; excessively fastidious and easily disgusted; affectedly dainty or refined; especially pleasing to the taste; noun something considered choice to eat"
            },
            {
                    "Dangerous",
                    "Dangerous - adj. causing fear or anxiety by threatening great harm;involving or causing danger or risk; liable to hurt or harm"
            },
            {
                    "Daring",
                    "Daring - adj. disposed to venture or take risks; radically new or original; noun the trait of being willing to undertake things that involve risk or danger; a challenge to do something dangerous or foolhardy"
            },
            {
                    "Daring",
                    "Daring - adj. disposed to venture or take risks; radically new or original; noun the trait of being willing to undertake things that involve risk or danger; a challenge to do something dangerous or foolhardy"
            },
            {
                    "Dark",
                    "Dark - adj. not giving performances; closed; brunet (used of hair or skin or eyes); devoid of or deficient in light or brightness; shadowed or black; (used of color) having a dark hue; marked by difficulty of style or expression; showing a brooding ill humor;secret; having skin rich in melanin pigments; causing dejection;lacking enlightenment or knowledge or culture; stemming from evil characteristics or forces; wicked or dishonorable; noun an unenlightened state; absence of light or illumination; an unilluminated area; absence of moral or spiritual values; the time after sunset and before sunrise while it is dark outside"
            },
            {
                    "Dauntless", "Dauntless - adj. invulnerable to fear or intimidation"
            },
            {
                    "Decisive",
                    "Decisive - adj. determining or having the power to determine an outcome; characterized by decision and firmness; unmistakable;forming or having the nature of a turning point or crisis"
            },
            {
                    "Deferential", "Deferential - adj. showing deference"
            },
            {
                    "Demanding",
                    "Demanding - adj. requiring more than usually expected or thought due; especially great patience and effort and skill"
            },
            {
                    "Demanding",
                    "Demanding - adj. requiring more than usually expected or thought due; especially great patience and effort and skill"
            },
            {
                    "Dependable",
                    "Dependable - adj. financially sound; consistent in performance or behavior; worthy of being depended on; worthy of reliance or trust"
            },
            {
                    "Depressed",
                    "Depressed - adj. having the central portion lower than the margin;lower than previously; flattened downward as if pressed from above or flattened along the dorsal and ventral surfaces; low in spirits"
            },
            {
                    "Desiccated",
                    "Desiccated - adj. thoroughly dried out; lacking vitality or spirit; lifeless; preserved by removing natural moisture"
            },
            {
                    "Despondent", "Despondent - adj. without or almost without hope"
            },
            {
                    "Determined",
                    "Determined - adj. having been learned or found or determined especially by investigation; characterized by great determination;determined or decided upon as by an authority; devoting full strength and concentrated attention to; strongly motivated to succeed"
            },
            {
                    "Devoted",
                    "Devoted - adj. (followed by `to') dedicated exclusively to a purpose or use; zealous in devotion or affection"
            },
            {
                    "Diligent",
                    "Diligent - adj. characterized by care and perseverance in carrying out tasks; quietly and steadily persevering especially in detail or exactness"
            },
            {
                    "Disaffected", "Disaffected - adj. discontented as toward authority"
            },
            {
                    "Disagreeable",
                    "Disagreeable - adj. not to your liking; not agreeing with your tastes or expectations"
            },
            {
                    "Discerning",
                    "Discerning - adj. having or revealing keen insight and good judgment; able to make or detect effects of great subtlety; sensitive;unobtrusively perceptive and sympathetic; quick to understand"
            },
            {
                    "discontented",
                    "discontented - adj. showing or experiencing dissatisfaction or restless longing"
            },
            {
                    "Discouraged",
                    "Discouraged - adj. lacking in resolution; made less hopeful or enthusiastic"
            },
            {
                    "Discreet",
                    "Discreet - adj. marked by prudence or modesty and wise self-restraint; heedful of potential consequences; unobtrusively perceptive and sympathetic"
            },
            {
                    "Dishonest",
                    "Dishonest - adj. deceptive or fraudulent; disposed to cheat or defraud or deceive; lacking truthfulness; lacking honesty and oblivious to what is honorable; capable of being corrupted"
            },
            {
                    "Disillusioned", "Disillusioned - adj. freed from illusion"
            },
            {
                    "Disloyal",
                    "Disloyal - adj. deserting your allegiance or duty to leader or cause or principle; showing lack of love for your country"
            },
            {
                    "Dismayed", "Dismayed - adj. struck with fear, dread, or consternation"
            },
            {
                    "Disorganized",
                    "Disorganized - adj. lacking order or methodical arrangement or function"
            },
            {
                    "Disparaging", "Disparaging - adj. expressive of low opinion"
            },
            {
                    "Disrespectful",
                    "Disrespectful - adj. exhibiting lack of respect; rude and discourteous; neither feeling nor showing respect"
            },
            {
                    "Dissatisfied", "Dissatisfied - adj. in a state of sulky dissatisfaction"
            },
            {
                    "Distressed",
                    "Distressed - adj. facing or experiencing financial trouble or difficulty; generalized feeling of distress; afflicted with or marked by anxious uneasiness or trouble or grief; suffering severe physical strain or distress"
            },
            {
                    "Domineering", "Domineering - adj. tending to domineer"
            },
            {
                    "Doubtful",
                    "Doubtful - adj. fraught with uncertainty or doubt; open to doubt or suspicion; unsettled in mind or opinion"
            },
            {
                    "Dreamer",
                    "Dreamer - noun someone who is dreaming; a person who escapes into a world of fantasy; someone guided more by ideals than by practical considerations"
            },
            {
                    "Dreamy",
                    "Dreamy - adj. dreamy in mood or nature; lacking spirit or liveliness"
            },
            {
                    "Dull",
                    "Dull - adj. (of business) not active or brisk; emitting or reflecting very little light; (of color) very low in saturation; highly diluted;darkened with overcast; not having a sharp edge or point; not keenly felt; lacking in liveliness or animation; being or made softer or less loud or clear; not clear and resonant; sounding as if striking with or against something relatively soft; blunted in responsiveness or sensibility; slow to learn or understand; lacking intellectual acuity; so lacking in interest as to cause mental weariness; verb make less lively or vigorous; become dull or lusterless in appearance; lose shine or brightness; make dull in appearance; make dull or blunt; become less interesting or attractive; make numb or insensitive; deaden (a sound or noise), especially by wrapping"
            },
            {
                    "Dutiful",
                    "Dutiful - adj. willingly obedient out of a sense of duty and respect"
            },
            {
                    "Eager",
                    "Eager - adj. having or showing keen interest or intense desire or impatient expectancy; marked by active interest and enthusiasm;noun a high wave (often dangerous) caused by tidal flow (as by colliding tidal currents or in a narrow estuary)"
            },
            {
                    "Easygoing",
                    "Easygoing - adj. living without undue worry; taking life easy; relaxed and informal in attitude or standards; not burdensome or demanding; borne or done easily and without hardship; not hurried or forced"
            },
            {
                    "Effervescent",
                    "Effervescent - adj. (of a liquid) giving off bubbles; marked by high spirits or excitement; used of wines and waters; charged naturally or artificially with carbon dioxide"
            },
            {
                    "Efficient",
                    "Efficient - adj. being effective without wasting time or effort or expense; able to accomplish a purpose; functioning effectively"
            },
            {
                    "Eloquent", "Eloquent - adj. expressing yourself readily, clearly, effectively"
            },
            {
                    "Embarrassed",
                    "Embarrassed - adj. made to feel uncomfortable because of shame or wounded pride; caused to feel self-conscious and uncomfortable; feeling or caused to feel uneasy and self-conscious"
            },
            {
                    "Encouraging",
                    "Encouraging - adj. giving courage or confidence or hope;furnishing support and encouragement"
            },
            {
                    "Energetic",
                    "Energetic - adj. possessing or exerting or displaying energy;working hard to promote an enterprise"
            },
            {
                    "Enthusiastic",
                    "Enthusiastic - adj. having or showing great excitement and interest"
            },
            {
                    "Equable", "Equable - adj. not easily irritated; not varying"
            },
            {
                    "Ethical",
                    "Ethical - adj. conforming to accepted standards of social or professional behavior; adhering to ethical and moral principles; of or relating to the philosophical study of ethics"
            },
            {
                    "Evil",
                    "Evil - adj. tending to cause great harm; morally bad or wrong;having the nature of vice; having or exerting a malignant influence;noun morally objectionable behavior; the quality of being morally wrong in principle or practice; that which causes harm or destruction or misfortune"
            },
            {
                    "Exacting",
                    "Exacting - adj. requiring precise accuracy; severe and unremitting in making demands; having complicated nutritional requirements; especially growing only in special artificial cultures"
            },
            {
                    "Excessive",
                    "Excessive - adj. beyond normal limits; unrestrained, especially with regard to feelings"
            },
            {
                    "Excitable",
                    "Excitable - adj. easily excited; capable of responding to stimuli"
            },
            {
                    "Excited",
                    "Excited - adj. in an aroused state; (of persons) excessively affected by emotion; (of e.g. a molecule) made reactive or more reactive;marked by uncontrolled excitement or emotion"
            },
            {
                    "Expert",
                    "Expert - adj. having or showing knowledge and skill and aptitude;noun a person with special knowledge or ability who performs skillfully"
            },
            {
                    "Exuberant",
                    "Exuberant - adj. produced or growing in extreme abundance;unrestrained, especially with regard to feelings; joyously unrestrained"
            },
            {
                    "Facetious", "Facetious - adj. cleverly amusing in tone"
            },
            {
                    "Fair",
                    "Fair - adj. (used of hair or skin) pale or light-colored; free of clouds or rain; (of a baseball) hit between the foul lines; free from favoritism or self-interest or bias or deception; or conforming with established standards or rules; attractively feminine; not excessive or extreme; very pleasing to the eye; (of a manuscript) having few alterations or corrections; lacking exceptional quality or ability;showing lack of favoritism; adv. without favoring one party, in a fair evenhanded manner; in conformity with the rules or laws and without fraud or cheating; noun a competitive exhibition of farm products; gathering of producers to promote business; a traveling show; having sideshows and rides and games of skill etc.; a sale of miscellany; often for charity; verb join so that the external surfaces blend smoothly"
            },
            {
                    "Faithful",
                    "Faithful - adj. steadfast in affection or allegiance; not having sexual relations with anyone except your husband or wife, or your boyfriend or girlfriend; marked by fidelity to an original; noun any loyal and steadfast following; a group of people who adhere to a common faith and habitually attend a given church"
            },
            {
                    "Faithless",
                    "Faithless - adj. having the character of, or characteristic of, a traitor"
            },
            {
                    "Fanciful",
                    "Fanciful - adj. indulging in or influenced by fancy; having a curiously intricate quality; not based on fact; dubious"
            },
            {
                    "Fearful",
                    "Fearful - adj. experiencing or showing fear; timid by nature or revealing timidity; extremely distressing; causing fear or dread or terror; lacking courage; ignobly timid and faint-hearted"
            },
            {
                    "Fearless",
                    "Fearless - adj. oblivious of dangers or perils or calmly resolute in facing them; invulnerable to fear or intimidation"
            },
            {
                    "Feisty", "Feisty - adj. showing courage; quick to take offense"
            },
            {
                    "ferocious", "ferocious - adj. marked by extreme and violent energy"
            },
            {
                    "Fidgety", "Fidgety - adj. unable to relax or be still"
            },
            {
                    "Fierce",
                    "Fierce - adj. marked by extreme intensity of emotions or convictions; inclined to react violently; fervid; violently agitated and turbulent; ruthless in competition; marked by extreme and violent energy"
            },
            {
                    "Fighter",
                    "Fighter - noun a high-speed military or naval airplane designed to destroy enemy aircraft in the air; someone who fights for a cause;someone who fights (or is fighting)"
            },
            {
                    "Finicky", "Finicky - adj. exacting especially about details"
            },
            {
                    "Flexible",
                    "Flexible - adj. bending and snapping back readily without breaking;able to flex; able to bend easily; capable of being changed; making or willing to make concessions; able to adjust readily to different conditions"
            },
            {
                    "Foolish",
                    "Foolish - adj. devoid of good sense or judgment; having or revealing stupidity"
            },
            {
                    "Forgetful",
                    "Forgetful - adj. failing to keep in mind; not mindful or attentive; (of memory) deficient in retentiveness or range"
            },
            {
                    "Forgiving",
                    "Forgiving - adj. inclined or able to forgive and show mercy;providing absolution"
            },
            {
                    "Formal",
                    "Formal - adj. being in accord with established forms and conventions and requirements (as e.g. of formal dress); (of spoken and written language) adhering to traditional standards of correctness and without casual, contracted, and colloquial forms;logically deductive; characteristic of or befitting a person in authority; refined or imposing in manner or appearance; befitting a royal court; represented in simplified or symbolic form; noun a gown for evening wear; a lavish dance requiring formal attire"
            },
            {
                    "Fortunate",
                    "Fortunate - adj. presaging good fortune; having unexpected good fortune; supremely favored or fortunate"
            },
            {
                    "Foul",
                    "Foul - adj. (of a baseball) not hit between the foul lines; especially of a ship's lines etc; disgustingly dirty; filled or smeared with offensive matter; characterized by obscenity; violating accepted standards or rules; offensively malodorous; (of a manuscript) defaced with changes; highly offensive; arousing aversion or disgust; noun an act that violates of the rules of a sport; verbbecome soiled and dirty; make unclean; spot, stain, or pollute;commit a foul; break the rules; hit a foul ball; make impure;become or cause to become obstructed"
            },
            {
                    "Frank",
                    "Frank - adj. clearly manifest; evident; characterized by directness in manner or speech; without subtlety or evasion; noun a smooth-textured sausage of minced beef or pork usually smoked; often served on a bread roll; a member of the ancient Germanic peoples who spread from the Rhine into the Roman Empire in the 4th century; verb exempt by means of an official pass or letter, as from customs or other checks; stamp with a postmark to indicate date and time of mailing"
            },
            {
                    "fresh",
                    "fresh - adj. improperly forward or bold; not yet used or soiled;recently made, produced, or harvested; not rotten; not canned or otherwise preserved; not containing or composed of salt water; (of a cycle) beginning or occurring again; original and of a kind not seen before; not soured or preserved; with restored energy; having recently calved and therefore able to give milk; imparting vitality and energy; free from impurities; adv. very recently"
            },
            {
                    "friendly",
                    "friendly - adj. characteristic of or befitting a friend; of or belonging to your own country's forces or those of an ally; easy to understand or use; favorably disposed; not antagonistic or hostile; noun troops belonging to or allied with your own military forces"
            },
            {
                    "Frightened",
                    "Frightened - adj. made afraid; thrown into a state of intense fear or desperation"
            },
            {
                    "Frustrated", "Frustrated - adj. disappointingly unsuccessful"
            },
            {
                    "Fun loving", ""
            },
            {
                    "Funny",
                    "Funny - adj. experiencing odd bodily sensations; beyond or deviating from the usual or expected; arousing or provoking laughter; not as expected; noun an account of an amusing incident (usually with a punch line)"
            },
            {
                    "Furious",
                    "Furious - adj. marked by extreme anger; (of the elements) as if showing violent anger; marked by extreme and violent energy"
            },
            {
                    "Fussy",
                    "Fussy - adj. exacting especially about details; perversely irritable;overcrowded or cluttered with detail"
            },
            {
                    "Garrulous", "Garrulous - adj. full of trivial conversation"
            },
            {
                    "Generous",
                    "Generous - adj. more than adequate; willing to give and share unstintingly; not petty in character and mind"
            },
            {
                    "Gentle",
                    "Gentle - adj. having or showing a kindly or tender nature; quiet and soothing; soft and mild; not harsh or stern or severe; marked by moderate steepness; having little impact; belonging to or characteristic of the nobility or aristocracy; easily handled or managed; verb stroke soothingly; cause to be more favorably inclined; gain the good will of; give a title to someone; make someone a member of the nobility"
            },
            {
                    "Giddy",
                    "Giddy - adj. lacking seriousness; given to frivolity; having or causing a whirling sensation; liable to falling"
            },
            {
                    "Gives up easily", ""
            },
            {
                    "Giving",
                    "Giving - adj. given or giving freely; noun disposing of property by voluntary transfer without receiving value in return; the act of giving;the imparting of news or promises etc."
            },
            {
                    "Glamorous", "Glamorous - adj. having an air of allure, romance and excitement"
            },
            {
                    "Gloomy",
                    "Gloomy - adj. characterized by hopelessness; filled with gloom;depressingly dark; causing dejection; reflecting gloom; causing or suggestive of sorrow or gloom"
            },
            {
                    "Glum", "Glum - adj. reflecting gloom; showing a brooding ill humor"
            },
            {
                    "Good",
                    "Good - adj. thorough; generally admired; resulting favorably; not left to spoil; not forged; having desirable or positive qualities especially those suitable for a thing specified; morally admirable; in excellent physical condition; appealing to the mind; agreeable or pleasing;most suitable or right for a particular purpose; capable of pleasing;of moral excellence; promoting or enhancing well-being; having the normally expected amount; with or in a close or intimate relationship; exerting force or influence; tending to promote physical well-being; beneficial to health; deserving of esteem and respect; having or showing knowledge and skill and aptitude;financially sound; adv. (often used as a combining form) in a good or proper or satisfactory manner or to a high standard (`good' is a nonstandard dialectal variant for `well'); in a complete and thorough manner (`good' is sometimes used informally for `thoroughly'); noun moral excellence or admirableness; that which is pleasing or valuable or useful; benefit; articles of commerce"
            },
            {
                    "graceful",
                    "graceful - adj. characterized by beauty of movement, style, form, or execution; suggesting taste, ease, and wealth"
            },
            {
                    "Greedy",
                    "Greedy - adj. wanting to eat or drink more than one can reasonably consume; immoderately desirous of acquiring e.g. wealth; (often followed by `for') ardently or excessively desirous"
            },
            {
                    "Gregarious",
                    "Gregarious - adj. instinctively or temperamentally seeking and enjoying the company of others; (of animals) tending to form a group with others of the same species; (of plants) growing in groups that are close together"
            },
            {
                    "Grouchy", "Grouchy - adj. perversely irritable"
            },
            {
                    "Grumpy", "Grumpy - adj. perversely irritable"
            },
            {
                    "Guilty",
                    "Guilty - adj. showing a sense of guilt; responsible for or chargeable with a reprehensible act; or marked by guilt"
            },
            {
                    "Gullible",
                    "Gullible - adj. easily tricked because of being too trusting; naive and easily deceived or tricked"
            },
            {
                    "Handsome",
                    "Handsome - adj. pleasing in appearance especially by reason of conformity to ideals of form and proportion; given or giving freely"
            },
            {
                    "Happy",
                    "Happy - adj. well expressed and to the point; enjoying or showing or marked by joy or pleasure or good fortune; marked by good fortune; eagerly disposed to act or to be of service"
            },
            {
                    "Hard-working",
                    "Hardworking - adj. characterized by hard work and perseverance"
            },
            {
                    "Hardy",
                    "Hardy - adj. able to survive under unfavorable conditions; having rugged physical strength; inured to fatigue or hardships; resolute and without fear; noun English novelist and poet (1840-1928);United States slapstick comedian who played the pompous and overbearing member of the Laurel and Hardy duo who made many films (1892-1957)"
            },
            {
                    "Harried",
                    "Harried - adj. troubled persistently especially with petty annoyances"
            },
            {
                    "Harsh",
                    "Harsh - adj. sharply disagreeable; rigorous; severe; unkind or cruel or uncivil; unpleasantly stern; disagreeable to the senses; of textures that are rough to the touch or substances consisting of relatively large particles"
            },
            {
                    "Hateful",
                    "Hateful - adj. evoking or deserving hatred; characterized by malice"
            },
            {
                    "Haughty",
                    "Haughty - adj. having or showing arrogant superiority to and disdain of those one views as unworthy"
            },
            {
                    "Healthy",
                    "Healthy - adj. having or indicating good health in body or mind; free from infirmity or disease; exercising or showing good judgment;financially secure and functioning well; promoting health; healthful;physically and mentally sound or healthy"
            },
            {
                    "Helpful",
                    "Helpful - adj. showing a willingness to cooperate; providing assistance or serving a useful function; of service or assistance"
            },
            {
                    "Hesitant",
                    "Hesitant - adj. lacking decisiveness of character; unable to act or decide quickly or firmly; acting with uncertainty or hesitance or lack of confidence"
            },
            {
                    "Honest",
                    "Honest - adj. not disposed to cheat or defraud; not deceptive or fraudulent; marked by truth; without pretensions; without dissimulation; frank; free from guile; habitually speaking the truth;worthy of being depended on"
            },
            {
                    "Hopeful",
                    "Hopeful - adj. having or manifesting or inspiring hope; presaging good fortune; noun an ambitious and aspiring young person"
            },
            {
                    "Hopeless",
                    "Hopeless - adj. (informal to emphasize how bad it is) beyond hope of management or reform; without hope because there seems to be no possibility of comfort or success; certain to fail; of a person unable to do something skillfully"
            },
            {
                    "Hospitable",
                    "Hospitable - adj. favorable to life and growth; disposed to treat guests and strangers with cordiality and generosity; having an open mind"
            },
            {
                    "Hot-tempered", ""
            },
            {
                    "Humble",
                    "Humble - adj. marked by meekness or modesty; not arrogant or prideful; used of unskilled work (especially domestic work); low or inferior in station or quality; of low birth or station (`base' is archaic in this sense); verb cause to be unpretentious; cause to feel shame; hurt the pride of"
            },
            {
                    "Humorous", "Humorous - adj. full of or characterized by humor"
            },
            {
                    "Ignorant",
                    "Ignorant - adj. uneducated in the fundamentals of a given art or branch of learning; lacking knowledge of a specific field;uneducated in general; lacking knowledge or sophistication;unaware because of a lack of relevant information or knowledge"
            },
            {
                    "Ill-bred", ""
            },
            {
                    "Imaginative",
                    "Imaginative - adj. (used of persons or artifacts) marked by independence and creativity in thought or action"
            },
            {
                    "Immaculate",
                    "Immaculate - adj. completely neat and clean; free from stain or blemish; without fault or error"
            },
            {
                    "Immature",
                    "Immature - adj. lacking in development; not yet mature;characteristic of a lack of maturity; (of birds) not yet having developed feathers; not fully developed or mature; not ripe; (used of living things especially persons) in an early period of life or development or growth"
            },
            {
                    "immobile",
                    "immobile - adj. not capable of movement or of being moved;securely fixed in place"
            },
            {
                    "Impartial",
                    "Impartial - adj. showing lack of favoritism; free from undue bias or preconceived opinions"
            },
            {
                    "Impatient",
                    "Impatient - adj. (usually followed by `to') full of eagerness; restless or short of temper under delay or opposition"
            },
            {
                    "impolite", "impolite - adj. not polite"
            },
            {
                    "Impudent",
                    "Impudent - adj. marked by casual disrespect; improperly forward or bold"
            },
            {
                    "Impulsive",
                    "Impulsive - adj. without forethought; proceeding from natural feeling or impulse without external stimulus; characterized by undue haste and lack of thought or deliberation; determined by chance or impulse or whim rather than by necessity or reason;having the power of driving or impelling"
            },
            {
                    "Inactive",
                    "Inactive - adj. not active physically or mentally; not engaged in full-time work; lacking activity; lying idle or unused; not progressing or increasing; or progressing slowly; not exerting influence or change;not in physical motion; not participating in a chemical reaction; chemically inert; lacking in energy or will; of e.g. volcanos; not erupting and not extinct; not involved in military operations"
            },
            {
                    "Inconsiderate",
                    "Inconsiderate - adj. lacking regard for the rights or feelings of others; without proper consideration or reflection"
            },
            {
                    "Inconsistent",
                    "Inconsistent - adj. displaying a lack of consistency; not capable of being made consistent or harmonious; not in agreement"
            },
            {
                    "Indecisive",
                    "Indecisive - adj. not definitely settling something; characterized by lack of decision and firmness; not clearly defined"
            },
            {
                    "independent",
                    "independent - adj. not dependent on or conditioned by or relative to anything else; not contingent; free from external control and constraint; (of a clause) capable of standing syntactically alone as a complete sentence; not controlled by a party or interest group; (of political bodies) not controlled by outside forces; noun a writer or artist who sells services to different employers without a long-term contract with any of them; a neutral or uncommitted person (especially in politics)"
            },
            {
                    "Indiscriminate",
                    "Indiscriminate - adj. not marked by fine distinctions; failing to make or recognize distinctions"
            },
            {
                    "Indolent",
                    "Indolent - adj. (of tumors e.g) slow to heal or develop and usually painless; disinclined to work or exertion"
            },
            {
                    "Industrious",
                    "Industrious - adj. characterized by hard work and perseverance;working hard to promote an enterprise"
            },
            {
                    "Inefficient",
                    "Inefficient - adj. not producing desired results; wasteful; lacking the ability or skill to perform effectively; inadequate"
            },
            {
                    "Inimitable", "Inimitable - adj. defying imitation; matchless"
            },
            {
                    "Innocent",
                    "Innocent - adj. (used of things) lacking sense or awareness;lacking intent or capacity to injure; not knowledgeable about something specified; free from evil or guilt; lacking in sophistication or worldliness; completely wanting or lacking; free from sin; noun a person who lacks knowledge of evil"
            },
            {
                    "Insecure",
                    "Insecure - adj. lacking self-confidence or assurance; lacking in security or safety; not firm or firmly fixed; likely to fail or give way; not safe from attack"
            },
            {
                    "Insincere", "Insincere - adj. lacking sincerity"
            },
            {
                    "Insipid",
                    "Insipid - adj. not pleasing to the sense of taste; lacking interest or significance; lacking significance or impact; lacking taste or flavor or tang"
            },
            {
                    "Insistent", "Insistent - adj. persistently continual; demanding attention"
            },
            {
                    "Insolent",
                    "Insolent - adj. unrestrained by convention or propriety; marked by casual disrespect"
            },
            {
                    "Intelligent",
                    "Intelligent - adj. having the capacity for thought and reason especially to a high degree; endowed with the capacity to reason;possessing sound knowledge; exercising or showing good judgment"
            },
            {
                    "Intolerant",
                    "Intolerant - adj. unwilling to tolerate difference of opinion; narrow-minded about cherished opinions"
            },
            {
                    "Intrepid", "Intrepid - adj. invulnerable to fear or intimidation"
            },
            {
                    "Inventive",
                    "Inventive - adj. (used of persons or artifacts) marked by independence and creativity in thought or action"
            },
            {
                    "Jealous",
                    "Jealous - adj. suspicious or unduly suspicious or fearful of being displaced by a rival; showing extreme cupidity; painfully desirous of another's advantages"
            },
            {
                    "Jolly",
                    "Jolly - adj. full of or showing high-spirited merriment; adv. used as an intensifier (`jolly' is used informally in Britain); noun a happy party; a yawl used by a ship's sailors for general work; verb be silly or tease one another"
            },
            {
                    "Jovial", "Jovial - adj. full of or showing high-spirited merriment"
            },
            {
                    "Joyful",
                    "Joyful - adj. full of or producing joy; full of high-spirited delight"
            },
            {
                    "Keen",
                    "Keen - adj. having a sharp cutting edge or point; as physically painful as if caused by a sharp instrument; very good; intense or sharp; having or demonstrating ability to recognize or draw fine distinctions; noun a funeral lament sung with loud wailing; verbexpress grief verbally"
            },
            {
                    "Kind",
                    "Kind - adj. tolerant and forgiving under provocation; agreeable, conducive to comfort; having or showing a tender and considerate and helpful nature; used especially of persons and their behavior;noun a category of things distinguished by some common characteristic or quality"
            },
            {
                    "Kindly",
                    "Kindly - adj. pleasant and agreeable; showing or motivated by sympathy and understanding and generosity; adv. in a kind manner or out of kindness"
            },
            {
                    "Lackadaisical",
                    "Lackadaisical - adj. idle or indolent especially in a dreamy way;lacking spirit or liveliness"
            },
            {
                    "Languid", "Languid - adj. lacking spirit or liveliness"
            },
            {
                    "Lazy", "Lazy - adj. moving slowly and gently; disinclined to work or exertion"
            },
            {
                    "Leader",
                    "Leader - noun a person who rules or guides or inspires others; a featured article of merchandise sold at a loss in order to draw customers"
            },
            {
                    "Lean",
                    "Lean - adj. not profitable or prosperous; lacking in mineral content or combustible material; containing little excess; lacking excess flesh; noun the property possessed by a line or surface that departs from the vertical; verb rely on for support; cause to lean or incline; to incline or bend from a vertical position; cause to lean to the side; have a tendency or disposition to do or be something; be inclined"
            },
            {
                    "Left-brain", ""
            },
            {
                    "Liar", "Liar - noun a person who has lied or who lies repeatedly"
            },
            {
                    "licentious",
                    "licentious - adj. lacking moral discipline; especially sexually unrestrained"
            },
            {
                    "Light",
                    "Light - adj. characterized by or emitting light; (used of color) having a relatively small amount of coloring agent; (of sleep) easily disturbed; demanding little effort; not burdensome; having relatively few calories; easily assimilated in the alimentary canal; not rich or heavily seasoned; of comparatively little physical weight or density;designed for ease of movement or to carry little weight;psychologically light; especially free from sadness or troubles; not great in degree or quantity or number; (physics, chemistry) not having atomic weight greater than average; of little intensity or power or force; moving easily and quickly; nimble; of the military or industry; using (or being) relatively small or light arms or equipment; intended primarily as entertainment; not serious or profound; having little importance; less than the correct or legal or full amount often deliberately so; casual and unrestrained in sexual behavior; (used of soil) loose and large-grained in consistency; (of sound or color) free from anything that dulls or dims; silly or trivial; used of vowels or syllables; pronounced with little or no stress; marked by temperance in indulgence; very thin and insubstantial; weak and likely to lose consciousness; adv.with few burdens; noun any device serving as a source of illumination; the visual effect of illumination on objects or scenes as created in pictures; public awareness; mental understanding as an enlightening experience; a particular perspective or aspect of a situation; a visual warning signal; an illuminated area; a person regarded very fondly; (physics) electromagnetic radiation that can produce a visual sensation; having abundant light or illumination; a condition of spiritual awareness; divine illumination; a device for lighting or igniting fuel or charges or fires; merriment expressed by a brightness or gleam or animation of countenance; the quality of being luminous; emitting or reflecting light; a divine presence believed by Quakers to enlighten and guide the soul; verb make lighter or brighter; begin to smoke; get off (a horse); to come to rest, settle; fall to somebody by assignment or lot; cause to start burning; subject to fire or great heat"
            },
            {
                    "Light-hearted", "Lighthearted - adj. carefree and happy and lighthearted"
            },
            {
                    "Limited",
                    "Limited - adj. including only a part; not unlimited; having a specific function or scope; small in range or scope; not excessive;mediocre; subject to limits or subjected to limits; noun public transport consisting of a fast train or bus that makes only a few scheduled stops"
            },
            {
                    "Lively",
                    "Lively - adj. characterized by energetic activity; filled with events or activity; full of life and energy; full of zest or vigor; full of spirit;elastic; rebounds readily; quick and energetic"
            },
            {
                    "Logical",
                    "Logical - adj. capable of or reflecting the capability for correct and valid reasoning; marked by an orderly, logical, and aesthetically consistent relation of parts; capable of thinking and expressing yourself in a clear and consistent manner; based on known statements or events or conditions"
            },
            {
                    "Lonely",
                    "Lonely - adj. remote or secluded; marked by dejection from being alone; characterized by or preferring solitude; lacking companions or companionship"
            },
            {
                    "Loquacious", "Loquacious - adj. full of trivial conversation"
            },
            {
                    "Loud",
                    "Loud - adj. characterized by or producing sound of great volume or intensity; attracting attention by showiness or bright colors; used chiefly as a direction or description in music; tastelessly showy;adv. with relatively high volume"
            },
            {
                    "Lovable",
                    "Lovable - adj. having characteristics that attract love or affection"
            },
            {
                    "Loves challenge", ""
            },
            {
                    "Loving", "Loving - adj. feeling or showing love and affection"
            },
            {
                    "Loyal",
                    "Loyal - adj. steadfast in allegiance or duty; unwavering in devotion to friend or vow or cause; inspired by love for your country"
            },
            {
                    "Lucky",
                    "Lucky - adj. blessed with good fortune; having or bringing good fortune; favoring or bringing good luck"
            },
            {
                    "Malicious", "Malicious - adj. having the nature of or resulting from malice"
            },
            {
                    "Mannerly", "Mannerly - adj. socially correct in behavior"
            },
            {
                    "Mature",
                    "Mature - adj. fully considered and perfected; having reached full natural growth or development; characteristic of maturity; (of birds) having developed feathers or plumage; often used in combination;fully developed or matured and ready to be eaten or used; verbdevelop and reach maturity; undergo maturation; become due for repayment; develop and work out fully in one's mind; cause to ripen and discharge pus; grow old or older; cause to ripen or develop fully"
            },
            {
                    "Mean",
                    "Mean - adj. (used of persons or behavior) characterized by or indicative of lack of generosity; excellent; of no value or worth;(used of sums of money) so small in amount as to deserve contempt; characterized by malice; having or showing an ignoble lack of honor or morality; approximating the statistical norm or average or expected value; marked by poverty befitting a beggar;noun an average of n numbers computed by adding some function of the numbers and dividing by some function of n; verb destine or designate for a certain purpose; denote or connote; mean or intend to express or convey; have a specified degree of importance; have in mind as a purpose; intend to refer to; have as a logical consequence"
            },
            {
                    "Meek",
                    "Meek - adj. evidencing little spirit or courage; overly submissive or compliant; humble in spirit or manner; suggesting retiring mildness or even cowed submissiveness; very docile"
            },
            {
                    "Merciful",
                    "Merciful - adj. (used conventionally of royalty and high nobility) gracious; showing or giving mercy"
            },
            {
                    "Messy", "Messy - adj. dirty and disorderly"
            },
            {
                    "Meticulous",
                    "Meticulous - adj. marked by extreme care in treatment of details;marked by precise accordance with details"
            },
            {
                    "Mischievous",
                    "Mischievous - adj. badly behaved; deliberately causing harm or damage; naughtily or annoyingly playful"
            },
            {
                    "Miserable",
                    "Miserable - adj. characterized by physical misery; very unhappy; full of misery; contemptibly small in amount; of the most contemptible kind; deserving or inciting pity; of very poor quality or condition"
            },
            {
                    "Moody",
                    "Moody - adj. subject to sharply varying moods; showing a brooding ill humor; noun United States evangelist (1837-1899); United States tennis player who dominated women's tennis in the 1920s and 1930s (born in 1906)"
            },
            {
                    "Mysterious",
                    "Mysterious - adj. having an import not apparent to the senses nor obvious to the intelligence; beyond ordinary understanding; of an obscure nature"
            },
            {
                    "Nagging", "Nagging - adj. continually complaining or faultfinding"
            },
            {
                    "Naïve",
                    "naive - adj. inexperienced; marked by or showing unaffected simplicity and lack of guile or worldly experience; not initiated; deficient in relevant experience; lacking information or instruction;of or created by one without formal training; simple or naive in style"
            },
            {
                    "Naughty", "Naughty - adj. badly behaved; suggestive of sexual impropriety"
            },
            {
                    "Neat",
                    "Neat - adj. without water; free from what is tawdry or unbecoming;clean or orderly; showing care in execution; free from clumsiness; precisely or deftly executed; very good"
            },
            {
                    "Negligent",
                    "Negligent - adj. marked by insufficient care or attention;characterized by neglect and undue lack of concern"
            },
            {
                    "Nervous",
                    "Nervous - adj. easily agitated; of or relating to the nervous system;unpredictably excitable (especially of horses); excited in anticipation; causing or fraught with or showing anxiety"
            },
            {
                    "Nice",
                    "Nice - adj. pleasant or pleasing or agreeable in nature or appearance; done with delicacy and skill; exhibiting courtesy and politeness; noting distinctions with nicety; excessively fastidious and easily disgusted; socially or conventionally correct; refined or virtuous; noun a city in southeastern France on the Mediterranean; the leading resort on the French Riviera"
            },
            {
                    "No purpose", ""
            },
            {
                    "Noisy",
                    "Noisy - adj. attracting attention by showiness or bright colors; full of or characterized by loud and nonmusical sounds"
            },
            {
                    "Not trustworthy", ""
            },
            {
                    "Obedient",
                    "Obedient - adj. dutifully complying with the commands or instructions of those in authority"
            },
            {
                    "Obese", "Obese - adj. excessively fat"
            },
            {
                    "Obliging",
                    "Obliging - adj. showing a cheerful willingness to do favors for others"
            },
            {
                    "Observant",
                    "Observant - adj. paying close attention especially to details; quick to notice; showing quick and keen perception; (of individuals) adhering strictly to laws and rules and customs"
            },
            {
                    "Open",
                    "Open - adj. ready for business; not having been filled; without undue constriction as from e.g. tenseness or inhibition; affording unobstructed entrance and exit; not shut or closed; affording free passage or access; used of mouth or eyes; having no protecting cover or enclosure; (set theory) of an interval that contains neither of its endpoints; open to or in view of all; accessible to all; not sealed or having been unsealed; not brought to a conclusion; subject to further thought; not requiring union membership; openly straightforward and direct without reserve or secretiveness;affording free passage or view; open and observable; not secret or hidden; with no protection or shield; ready or willing to receive favorably; (of textures) full of small openings or gaps; possibly accepting or permitting; not defended or capable of being defended; noun information that has become public; a tournament in which both professionals and amateurs may play; a clear or unobstructed space or expanse of land or water; where the air is unconfined; verb make available; become available; make the opening move; cause to open or to become open; become open;display the contents of a file or start an application as on a computer; begin or set in action, of meetings, speeches, recitals, etc.; start to operate or function or cause to start operating or functioning; have an opening or passage or outlet; spread out or open from a closed or folded state; afford access to"
            },
            {
                    "Optimistic",
                    "Optimistic - adj. expecting the best in this best of all possible worlds; expecting the best"
            },
            {
                    "Organised", "Organised - adj. being a member of or formed into a labor union"
            },
            {
                    "Outspoken",
                    "Outspoken - adj. given to expressing yourself freely or insistently;characterized by directness in manner or speech; without subtlety or evasion"
            },
            {
                    "Overweight",
                    "Overweight - adj. usually describes a large person who is fat but has a large frame to carry it; noun the property of excessive fatness"
            },
            {
                    "Patient",
                    "Patient - adj. enduring without protest or complaint; enduring trying circumstances with even temper or characterized by such endurance; noun a person who requires medical care; the semantic role of an entity that is not the agent but is directly involved in or affected by the happening denoted by the verb in the clause"
            },
            {
                    "Patriotic", "Patriotic - adj. inspired by love for your country"
            },
            {
                    "Peaceful",
                    "Peaceful - adj. not disturbed by strife or turmoil or war; (of groups) not violent or disorderly; peacefully resistant in response to injustice"
            },
            {
                    "Perserverant", ""
            },
            {
                    "Persistent",
                    "Persistent - adj. never-ceasing; retained; not shed; continually recurring to the mind"
            },
            {
                    "Persuasive",
                    "Persuasive - adj. capable of convincing; tending or intended or having the power to induce action or belief"
            },
            {
                    "Perverse",
                    "Perverse - adj. marked by a disposition to oppose and contradict;marked by immorality; deviating from what is considered right or proper or good; resistant to guidance or discipline"
            },
            {
                    "Pessimistic",
                    "Pessimistic - adj. expecting the worst in this worst of all possible worlds"
            },
            {
                    "Picky", "Picky - adj. exacting especially about details"
            },
            {
                    "Pitiful",
                    "Pitiful - adj. inspiring mixed contempt and pity; deserving or inciting pity; bad; unfortunate"
            },
            {
                    "Plain",
                    "Plain - adj. lacking embellishment or ornamentation; free from any effort to soften to disguise; lacking patterns especially in color; not elaborate or elaborated; simple; not mixed with extraneous elements; lacking in physical beauty or proportion; clearly revealed to the mind or the senses or judgment; adv. unmistakably (`plain' is often used informally for `plainly'); noun extensive tract of level open land; a basic knitting stitch; verb express complaints, discontent, displeasure, or unhappiness"
            },
            {
                    "Playful", "Playful - adj. full of fun and high spirits"
            },
            {
                    "pleasant",
                    "pleasant - adj. pleasant in manner or behavior; affording pleasure; being in harmony with your taste or likings"
            },
            {
                    "Pleasing",
                    "Pleasing - adj. able to please or win approval; giving pleasure and satisfaction; giving pleasure or satisfaction; aesthetically pleasing;noun the act of one who pleases"
            },
            {
                    "Polite",
                    "Polite - adj. showing regard for others in manners, speech, behavior, etc.; not rude; marked by satisfactory (or especially minimal) adherence to social usages and sufficient but not noteworthy consideration for others; marked by refinement in taste and manners"
            },
            {
                    "Poor",
                    "Poor - adj. unsatisfactory; having little money or few possessions;lacking in specific resources, qualities or substances;characterized by or indicating poverty; deserving or inciting pity; not sufficient to meet a need; noun people without possessions or wealth (considered as a group)"
            },
            {
                    "Popular",
                    "Popular - adj. (of music or art) new and of general appeal (especially among young people); carried on by or for the people (or citizens) at large; regarded with great favor, approval, or affection especially by the general public; representing or appealing to or adapted for the benefit of the people at large"
            },
            {
                    "Positive",
                    "Positive - adj. formally laid down or imposed; characterized by or displaying affirmation or acceptance or certainty etc.; greater than zero; reckoned, situated or tending in the direction which naturally or arbitrarily is taken to indicate increase or progress or onward motion; indicating existence or presence of a suspected condition or pathogen; having a positive electric charge; involving advantage or good; persuaded of; very sure; marked by excessive confidence;impossible to deny or disprove; of or relating to positivism; noun a film showing a photographic image whose tones correspond to those of the original subject"
            },
            {
                    "Precise",
                    "Precise - adj. sharply exact or accurate or delimited; (of ideas, images, representations, expressions) characterized by perfect conformity to fact or truth ; strictly correct"
            },
            {
                    "Pretty",
                    "Pretty - adj. pleasing by delicacy or grace; not imposing; (used ironically) unexpectedly bad; adv. used as an intensifier (`jolly' is used informally in Britain)"
            },
            {
                    "Prim",
                    "Prim - adj. exaggeratedly proper; affectedly dainty or refined; verbdress primly; contract one's lips; assume a prim appearance"
            },
            {
                    "primitive",
                    "primitive - adj. used of preliterate or tribal or nonindustrial societies; of or created by one without formal training; simple or naive in style; little evolved from or characteristic of an earlier ancestral type; belonging to an early stage of technical development; characterized by simplicity and (often) crudeness;noun a word serving as the basis for inflected or derived forms; a mathematical expression from which another expression is derived; a person who belongs to an early stage of civilization"
            },
            {
                    "Proper",
                    "Proper - adj. appropriate for a condition or purpose or occasion or a person's character, needs; marked by suitability or rightness or appropriateness; having all the qualities typical of the thing specified"
            },
            {
                    "Proud",
                    "Proud - adj. feeling self-respect or pleasure in something by which you measure your self-worth; or being a reason for pride; having or displaying great dignity or nobility"
            },
            {
                    "Prudent", "Prudent - adj. careful and sensible; marked by sound judgment"
            },
            {
                    "Punctual",
                    "Punctual - adj. acting or arriving or performed exactly at the time appointed"
            },
            {
                    "Purposeful",
                    "Purposeful - adj. having meaning through having an aim; serving as or indicating the existence of a purpose or goal"
            },
            {
                    "Quarrelsome", "Quarrelsome - adj. given to quarreling"
            },
            {
                    "Quick",
                    "Quick - adj. easily aroused or excited; accomplished rapidly and without delay; apprehending and responding with speed and sensitivity; moving quickly and lightly; performed with little or no delay; hurried and brief; adv. with little or no delay; noun any area of the body that is highly sensitive to pain (as the flesh underneath the skin or a fingernail or toenail)"
            },
            {
                    "Quick-tempered", ""
            },
            {
                    "Quiet",
                    "Quiet - adj. of the sun; characterized by a low level of surface phenomena like sun spots e.g.; not showy or obtrusive; free of noise or uproar; or making little if any sound; characterized by an absence or near absence of agitation or activity; (of a body of water) free from disturbance by heavy waves; in a softened tone; adv. with little or no activity or no agitation (`quiet' is a nonstandard variant for `quietly'); noun a disposition free from stress or emotion; the absence of sound; an untroubled state; free from disturbances; a period of calm weather; verb make calm or still; become quiet or quieter"
            },
            {
                    "Rational",
                    "Rational - adj. having its source in or being guided by the intellect (distinguished from experience or emotion); consistent with or based on or using reason; capable of being expressed as a quotient of integers; of or associated with or requiring the use of the mind; noun an integer or a fraction"
            },
            {
                    "Rawboned", "Rawboned - adj. having a lean and bony physique"
            },
            {
                    "Reasonable",
                    "Reasonable - adj. marked by sound judgment; showing reason or sound judgment; not excessive or extreme"
            },
            {
                    "Reckless",
                    "Reckless - adj. marked by defiant disregard for danger or consequences; characterized by careless unconcern"
            },
            {
                    "Relaxed", "Relaxed - adj. made less tense or rigid; without strain or anxiety"
            },
            {
                    "Reliable",
                    "Reliable - adj. worthy of reliance or trust; conforming to fact and therefore worthy of belief; worthy of being depended on"
            },
            {
                    "Religious",
                    "Religious - adj. having or showing belief in and reverence for a deity; concerned with sacred matters or religion or the church;extremely scrupulous and conscientious; noun a member of a religious order who is bound by vows of poverty and chastity and obedience"
            },
            {
                    "Repugnant", "Repugnant - adj. offensive to the mind"
            },
            {
                    "Repulsive",
                    "Repulsive - adj. possessing the ability to repel; so extremely ugly as to be terrifying; offensive to the mind"
            },
            {
                    "Reserved",
                    "Reserved - adj. cool and formal in manner; marked by self-restraint and reticence; set aside for the use of a particular person or party"
            },
            {
                    "Resourceful",
                    "Resourceful - adj. having inner resources; adroit or imaginative"
            },
            {
                    "Respectful",
                    "Respectful - adj. full of or exhibiting respect; feeling or manifesting veneration"
            },
            {
                    "Responsible",
                    "Responsible - adj. being the agent or cause; worthy of or requiring responsibility or trust; or held accountable; having an acceptable credit rating"
            },
            {
                    "Restless",
                    "Restless - adj. worried and uneasy; ceaselessly in motion; unable to relax or be still; not affording rest"
            },
            {
                    "Rich",
                    "Rich - adj. pleasantly full and mellow; very productive; possessing material wealth; having an abundant supply of desirable qualities or substances (especially natural resources); suggestive of or characterized by great expense; high in mineral content; having a high proportion of fuel to air; of great worth or quality; containing plenty of fat, or eggs, or sugar; affording an abundant supply;strong; intense; marked by great fruitfulness; marked by richness and fullness of flavor; noun people who have possessions and wealth (considered as a group)"
            },
            {
                    "Rigid",
                    "Rigid - adj. incapable of or resistant to bending; designating an airship or dirigible having a form maintained by a stiff unyielding frame or structure; incapable of compromise or flexibility; incapable of adapting or changing to meet circumstances; fixed and unmoving"
            },
            {
                    "Risk-taking", ""
            },
            {
                    "Rough",
                    "Rough - adj. not perfected; (of persons or behavior) lacking refinement or finesse; having or caused by an irregular surface;causing or characterized by jolts and irregular movements; of the margin of a leaf shape; having the edge cut or fringed or scalloped;ready and able to resort to force or violence; unpleasantly harsh or grating in sound; violently agitated and turbulent; not shaped by cutting or trimming; full of hardship or trials; not quite exact or correct; unkind or cruel or uncivil; unpleasantly stern; not carefully or expertly made; adv. with rough motion as over a rough surface;with roughness or violence (`rough' is an informal variant for `roughly'); noun the part of a golf course bordering the fairway where the grass is not cut short; verb prepare in preliminary or sketchy form"
            },
            {
                    "rowdy",
                    "rowdy - adj. disturbing the public peace; loud and rough; noun a cruel and brutal fellow"
            },
            {
                    "Rude",
                    "Rude - adj. socially incorrect in behavior; lacking civility or good manners; belonging to an early stage of technical development; characterized by simplicity and (often) crudeness; (of persons) lacking in refinement or grace; (used especially of commodities) being unprocessed or manufactured using only simple or minimal processes"
            },
            {
                    "Ruthless", "Ruthless - adj. without mercy or pity"
            },
            {
                    "Sad",
                    "Sad - adj. experiencing or showing sorrow or unhappiness; of things that make you feel sad; bad; unfortunate"
            },
            {
                    "Safe",
                    "Safe - adj. (of an undertaking) secure from risk; free from danger or the risk of harm; having reached a base without being put out; in safekeeping; financially sound; noun strongbox where valuables can be safely kept; a ventilated or refrigerated cupboard for securing provisions from pests; contraceptive device consisting of a sheath of thin rubber or latex that is worn over the penis during intercourse"
            },
            {
                    "Satisfied", "Satisfied - adj. filled with satisfaction; allayed"
            },
            {
                    "Scared", "Scared - adj. made afraid"
            },
            {
                    "Scatty",
                    "Scatty - adj. lost in thought; showing preoccupation; lacking sense or discretion"
            },
            {
                    "Scheming",
                    "Scheming - adj. concealing crafty designs for advancing your own interest; used of persons"
            },
            {
                    "Scrawny", "Scrawny - adj. inferior in size or quality; being very thin"
            },
            {
                    "Scruffy", "Scruffy - adj. shabby and untidy"
            },
            {
                    "Secretive",
                    "Secretive - adj. inclined to secrecy or reticence about divulging information"
            },
            {
                    "Secure",
                    "Secure - adj. free from fear or doubt; easy in mind; free from danger or risk; not likely to fail or give way; kept safe or defended from danger or injury or loss; financially sound; able to withstand attack; verb assure payment of; make certain of; furnish with battens; cause to be firmly attached; fill or close tightly with or as if with a plug; get by special effort"
            },
            {
                    "Self-centered", ""
            },
            {
                    "Self-confident", ""
            },
            {
                    "Self-controlling", ""
            },
            {
                    "Selfish",
                    "Selfish - adj. concerned chiefly or only with yourself and your advantage to the exclusion of others"
            },
            {
                    "Sensitive",
                    "Sensitive - adj. of or pertaining to classified information or matters affecting national security; hurting; responsive to physical stimuli;being susceptible to the attitudes, feelings, or circumstances of others; able to feel or perceive; noun someone who serves as an intermediary between the living and the dead"
            },
            {
                    "Sentimental",
                    "Sentimental - adj. given to or marked by sentiment or sentimentality; effusively or insincerely emotional"
            },
            {
                    "Serious",
                    "Serious - adj. requiring effort or concentration; complex and not easy to answer or solve; of great consequence; concerned with work or important matters rather than play or trivialities; causing fear or anxiety by threatening great harm; appealing to the mind;completely lacking in playfulness"
            },
            {
                    "Sharp",
                    "Sharp - adj. having or made by a thin edge or sharp point; suitable for cutting or piercing; keenly and painfully felt; as if caused by a sharp edge or point; quick and forceful; very sudden and in great amount or degree; raised in pitch by one chromatic semitone;harsh; marked by practical hardheaded intelligence; (of something seen or heard) clearly defined; extremely steep; having or emitting a high-pitched and sharp tone or tones; having or demonstrating ability to recognize or draw fine distinctions; ending in a sharp point; adv. changing suddenly in direction and degree; noun a long thin sewing needle with a sharp point; a musical notation indicating one half step higher than the note named"
            },
            {
                    "Sharp-witted", ""
            },
            {
                    "Shiftless",
                    "Shiftless - adj. lacking or characterized by lack of ambition or initiative; lazy"
            },
            {
                    "Short",
                    "Short - adj. tending to crumble or break into flakes due to a large amount of shortening; (primarily spatial sense) having little length or lacking in length; primarily temporal sense; indicating or being or seeming to be limited in duration; of speech sounds or syllables of relatively short duration; not holding securities or commodities that one sells in expectation of a fall in prices; lacking foresight or scope; low in stature; not tall; marked by rude or peremptory shortness; (of memory) deficient in retentiveness or range; not sufficient to meet a need; less than the correct or legal or full amount often deliberately so; adv. at a disadvantage; so as to interrupt; at some point or distance before a goal is reached; clean across; without possessing something at the time it is contractually sold; quickly and without warning; in a curt, abrupt and discourteous manner; noun the location on a baseball field where the shortstop is stationed; the fielding position of the player on a baseball team who is stationed between second and third base;accidental contact between two points in an electric circuit that have a potential difference; verb create a short circuit in; cheat someone by not returning him enough money"
            },
            {
                    "Shrewd",
                    "Shrewd - adj. marked by practical hardheaded intelligence; used of persons"
            },
            {
                    "Shy",
                    "Shy - adj. wary and distrustful; disposed to avoid persons or things; easily startled or frightened; short; lacking self-confidence;noun a quick throw; verb throw quickly; start suddenly, as from fight"
            },
            {
                    "Silly",
                    "Silly - adj. dazed from or as if from repeated blows; inspiring scornful pity; lacking seriousness; given to frivolity; ludicrous, foolish; noun a word used for misbehaving children"
            },
            {
                    "Simple",
                    "Simple - adj. unornamented; (botany) of leaf shapes; of leaves having no divisions or subdivisions; having few parts; not complex or complicated or involved; easy and not involved or complicated;apart from anything else; without additions or modifications;lacking mental capacity and devoid of subtlety; exhibiting childlike simplicity and credulity; noun any herbaceous plant having medicinal properties; a person lacking intelligence or common sense"
            },
            {
                    "simple-minded", ""
            },
            {
                    "Sincere",
                    "Sincere - adj. open and genuine; not deceitful; characterized by a firm and humorless belief in the validity of your opinions"
            },
            {
                    "skillful",
                    "skillful - adj. done with delicacy and skill; having or showing knowledge and skill and aptitude"
            },
            {
                    "Sly", "Sly - adj. marked by skill in deception"
            },
            {
                    "Smart",
                    "Smart - adj. capable of independent and apparently intelligent action; showing mental alertness and calculation and resourcefulness; quick and brisk; painfully severe; improperly forward or bold; elegant and stylish; characterized by quickness and ease in learning; noun a kind of pain such as that caused by a wound or a burn or a sore; verb be the source of pain"
            },
            {
                    "Sneaky",
                    "Sneaky - adj. marked by deception; marked by quiet and caution and secrecy; taking pains to avoid being observed"
            },
            {
                    "Soft-hearted", "Softhearted - adj. easily moved to pity or sorrow"
            },
            {
                    "Solitary",
                    "Solitary - adj. remote or secluded; being the only one; single and isolated from others; characterized by or preferring solitude;lacking companions or companionship; of plants and animals; not growing or living in groups or colonies; noun one who lives in solitude; confinement of a prisoner in isolation from other prisoners"
            },
            {
                    "Sorry",
                    "Sorry - adj. causing dejection; feeling or expressing sorrow or pity;bad; unfortunate; feeling or expressing regret or sorrow or a sense of loss over something done or undone; without merit"
            },
            {
                    "Spendthrift",
                    "Spendthrift - adj. recklessly wasteful; noun someone who spends money prodigally"
            },
            {
                    "Spoiled",
                    "Spoiled - adj. having the character or disposition harmed by pampering or oversolicitous attention; (of foodstuffs) not in an edible or usable condition"
            },
            {
                    "Sterile",
                    "Sterile - adj. deficient in originality or creativity; lacking powers of invention; incapable of reproducing; free of or using methods to keep free of pathological microorganisms"
            },
            {
                    "Stern",
                    "Stern - adj. severe and unremitting in making demands; of a stern or strict bearing or demeanor; forbidding in aspect; not to be placated or appeased or moved by entreaty; severely simple; nounthe rear part of a ship; United States concert violinist (born in Russia in 1920); the fleshy part of the human body that you sit on"
            },
            {
                    "Stingy",
                    "Stingy - adj. unwilling to spend; deficient in amount or quality or extent"
            },
            {
                    "Strange",
                    "Strange - adj. not known before; being definitely out of the ordinary and unexpected; slightly odd or even a bit weird; relating to or originating in or characteristic of another place or part of the world"
            },
            {
                    "Strict",
                    "Strict - adj. severe and unremitting in making demands; rigidly accurate; allowing no deviation from a standard; characterized by strictness, severity, or restraint; incapable of compromise or flexibility; (of rules) stringently enforced"
            },
            {
                    "Strong",
                    "Strong - adj. freshly made or left; not faint or feeble; of verbs not having standard (or regular) inflection; having strength or power greater than average or expected; strong and sure; being distilled rather than fermented; having a high alcoholic content; having a strong physiological or chemical effect; having or wielding force or authority; of good quality and condition; solidly built; able to withstand attack"
            },
            {
                    "Stubborn",
                    "Stubborn - adj. tenaciously unwilling or marked by tenacious unwillingness to yield; not responding to treatment"
            },
            {
                    "Studious",
                    "Studious - adj. marked by care and effort; characterized by diligent study and fondness for reading"
            },
            {
                    "Submissive",
                    "Submissive - adj. inclined or willing to submit to orders or wishes of others or showing such inclination; abjectly submissive; characteristic of a slave or servant"
            },
            {
                    "Successful",
                    "Successful - adj. having succeeded or being marked by a favorable outcome"
            },
            {
                    "Supersticious", ""
            },
            {
                    "Supportive", "Supportive - adj. furnishing support or assistance"
            },
            {
                    "Suspicious",
                    "Suspicious - adj. not as expected; openly distrustful and unwilling to confide"
            },
            {
                    "Sweet",
                    "Sweet - adj. pleasing to the senses; (used of wines) having a high residual sugar content; having or denoting the characteristic taste of sugar; having a natural fragrance; not containing or composed of salt water; having a sweet nature befitting an angel or cherub;pleasing to the ear; pleasing to the mind or feeling; with sweetening added; not soured or preserved; adv. in an affectionate or loving manner (`sweet' is sometimes a poetic or informal variant of `sweetly'); noun the taste experience when sugar dissolves in the mouth; a food rich in sugar; English phonetician; one of the founders of modern phonetics (1845-1912); the property of tasting as if it contains sugar; a dish served as the last course of a meal"
            },
            {
                    "Tactful",
                    "Tactful - adj. showing skill and sensitivity in dealing with people;having or showing a sense of what is fitting and considerate in dealing with others"
            },
            {
                    "Tactless",
                    "Tactless - adj. lacking or showing a lack of what is fitting and considerate in dealing with others; revealing lack of perceptiveness or judgment or finesse"
            },
            {
                    "Talented", "Talented - adj. endowed with talent or talents"
            },
            {
                    "Talkative",
                    "Talkative - adj. friendly and open and willing to talk; unwisely talking too much; full of trivial conversation"
            },
            {
                    "Tall",
                    "Tall - adj. impressively difficult; great in vertical dimension; high in stature; too improbable to admit of belief; lofty in style; noun a garment size for a tall person"
            },
            {
                    "Tardy", "Tardy - adj. after the expected or usual time; delayed"
            },
            {
                    "Temperate",
                    "Temperate - adj. not extreme in behavior; (of weather or climate) free from extremes; mild; or characteristic of such weather or climate; not extreme"
            },
            {
                    "Thankful", "Thankful - adj. feeling or showing gratitude"
            },
            {
                    "Thorough",
                    "Thorough - adj. painstakingly careful and accurate; very thorough; exhaustively complete"
            },
            {
                    "Thoughtful",
                    "Thoughtful - adj. considerate of the feelings or well-being of others; having intellectual depth; acting with or showing thought and good sense; exhibiting or characterized by careful thought;taking heed; giving close and thoughtful attention"
            },
            {
                    "Thoughtless",
                    "Thoughtless - adj. without care or thought for others; showing lack of careful thought; marked by or paying little heed or attention"
            },
            {
                    "Thrifty",
                    "Thrifty - adj. careful and diligent in the use of resources; mindful of the future in spending money"
            },
            {
                    "Thrilled", "Thrilled - adj. feeling intense pleasurable excitement"
            },
            {
                    "Timid",
                    "Timid - adj. showing fear and lack of confidence; lacking conviction or boldness or courage; lacking self-confidence; noun people who are fearful and cautious"
            },
            {
                    "Tired",
                    "Tired - adj. depleted of strength or energy; repeated too often; overfamiliar through overuse"
            },
            {
                    "Tireless",
                    "Tireless - adj. characterized by hard work and perseverance;showing sustained enthusiastic action with unflagging vitality"
            },
            {
                    "Tolerant",
                    "Tolerant - adj. showing the capacity for endurance; able to tolerate environmental conditions or physiological stress; showing respect for the rights or opinions or practices of others; showing or characterized by broad-mindedness; tolerant and forgiving under provocation"
            },
            {
                    "Touchy",
                    "Touchy - adj. difficult to handle; requiring great tact; quick to take offense"
            },
            {
                    "Tough",
                    "Tough - adj. resistant to cutting or chewing; physically toughened;not given to gentleness or sentimentality; feeling physical discomfort or pain (`tough' is occasionally used colloquially for `bad'); substantially made or constructed; making great mental demands; hard to comprehend or solve or believe; very difficult; severely testing stamina or resolution; unfortunate or hard to bear;violent and lawless; noun a cruel and brutal fellow; an aggressive and violent young criminal; someone who learned to fight in the streets rather than being formally trained in the sport of boxing"
            },
            {
                    "Trusting",
                    "Trusting - adj. inclined to believe or confide readily; full of trust"
            },
            {
                    "Trustworthy",
                    "Trustworthy - adj. taking responsibility for one's conduct and obligations; worthy of trust or belief"
            },
            {
                    "Truthful",
                    "Truthful - adj. expressing or given to expressing the truth;conforming to truth"
            },
            {
                    "Ugly",
                    "Ugly - adj. displeasing to the senses; provoking horror; morally reprehensible; inclined to anger or bad feelings with overtones of menace"
            },
            {
                    "Unconcerned",
                    "Unconcerned - adj. lacking in interest or care or feeling; not occupied or engaged with; easy in mind; not worried"
            },
            {
                    "Uncoordinated",
                    "Uncoordinated - adj. lacking the skillful and effective interaction of muscle movements; lacking in cooperative planning and organization"
            },
            {
                    "Undependable",
                    "Undependable - adj. liable to be erroneous or misleading; not worthy of reliance or trust"
            },
            {
                    "Understanding",
                    "Understanding - adj. characterized by understanding based on comprehension and discernment and empathy; noun the cognitive condition of someone who understands; the capacity for rational thought or inference or discrimination; an inclination to support or be loyal to or to agree with an opinion; the statement (oral or written) of an exchange of promises"
            },
            {
                    "Unforgiving",
                    "Unforgiving - adj. unwilling or unable to forgive or show mercy; not to be placated or appeased or moved by entreaty"
            },
            {
                    "Unfriendly",
                    "Unfriendly - adj. not disposed to friendship or friendliness; not easy to understand or use; not friendly; very unfavorable to life or growth"
            },
            {
                    "Ungrateful",
                    "Ungrateful - adj. not feeling or showing gratitude; disagreeable"
            },
            {
                    "Unhappy",
                    "Unhappy - adj. experiencing or marked by or causing sadness or sorrow or discontent; causing discomfort; generalized feeling of distress; marked by or producing unhappiness"
            },
            {
                    "Unkind",
                    "Unkind - adj. lacking kindness; deficient in humane and kindly feelings"
            },
            {
                    "Unmerciful", "Unmerciful - adj. having or showing no mercy"
            },
            {
                    "Unselfish",
                    "Unselfish - adj. not greedy; disregarding your own advantages and welfare over those of others"
            },
            {
                    "Unsuitable",
                    "Unsuitable - adj. not appropriate for a purpose or occasion; not meant or adapted for a particular purpose; not conducive to good moral development; not worthy of being chosen (especially as a spouse); not capable of being applied"
            },
            {
                    "Upset",
                    "Upset - adj. used of an unexpected defeat of a team favored to win;mildly physically distressed; thrown into a state of disarray or confusion; afflicted with or marked by anxious uneasiness or trouble or grief; having been turned so that the bottom is no longer the bottom; noun the act of upsetting something; the act of disturbing the mind or body; a tool used to thicken or spread metal (the end of a bar or a rivet etc.) by forging or hammering or swaging; an improbable and unexpected victory; condition in which there is a disturbance of normal functioning; an unhappy and worried mental state; verb disturb the balance or stability of; defeat suddenly and unexpectedly; cause to lose one's composure; form metals with a swage; move deeply; cause to overturn from an upright or normal position"
            },
            {
                    "useful", "useful - adj. being of use or service; having a useful function"
            },
            {
                    "vacant",
                    "vacant - adj. without an occupant or incumbent; void of thought or knowledge"
            },
            {
                    "Violent",
                    "Violent - adj. (of colors or sounds) intensely vivid or loud; effected by force or injury rather than natural causes; acting with or marked by or resulting from great force or energy or emotional intensity;characterized by violence or bloodshed; marked by extreme intensity of emotions or convictions; inclined to react violently; fervid"
            },
            {
                    "Virtuous", "Virtuous - adj. morally excellent; in a state of sexual virginity"
            },
            {
                    "Warm",
                    "Warm - adj. of a seeker; near to the object sought; uncomfortable because of possible danger or trouble; characterized by liveliness or excitement or disagreement; having or producing a comfortable and agreeable degree of heat or imparting or maintaining heat;psychologically warm; friendly and responsive; (color) inducing the impression of warmth; used especially of reds and oranges and yellows; characterized by strong enthusiasm; easily aroused or excited; freshly made or left; having or displaying warmth or affection; adv. in a warm manner; verb make warm or warmer; get warm or warmer"
            },
            {
                    "Weak",
                    "Weak - adj. deficient in intelligence or mental power; likely to fail under stress or pressure; not having authority, political strength, or governing power; (used of verbs) having standard (or regular) inflection; deficient or lacking in some skill; having little physical or spiritual strength; tending downward in price; overly diluted; thin and insipid; having the attributes of man as opposed to e.g. divine beings; deficient in magnitude; barely perceptible; lacking clarity or brightness or loudness etc; lacking physical strength or vitality;used of vowels or syllables; pronounced with little or no stress"
            },
            {
                    "Wicked",
                    "Wicked - adj. morally bad in principle or practice; intensely or extremely bad or unpleasant in degree or quality; highly offensive; arousing aversion or disgust; having committed unrighteous acts;naughtily or annoyingly playful"
            },
            {
                    "Wild",
                    "Wild - adj. deviating widely from an intended course; in a state of extreme emotion; in a natural state; not tamed or domesticated or cultivated; marked by extreme lack of restraint or control; (of the elements) as if showing violent anger; without civilizing influences;intensely enthusiastic about or preoccupied with; located in a dismal or remote area; desolate; (of colors or sounds) intensely vivid or loud; extravagantly fanciful and unrealistic; foolish; involving risk or danger; talking or behaving irrationally; without a basis in reason or fact; adv. in a wild or undomesticated manner; in an uncontrolled and rampant manner; noun a wild primitive state untouched by civilization; a wild and uninhabited area left in its natural condition"
            },
            {
                    "Wise",
                    "Wise - adj. having or prompted by wisdom or discernment;improperly forward or bold; evidencing the possession of inside information; marked by the exercise of good judgment or common sense in practical matters; noun a way of doing or being; United States religious leader (born in Bohemia) who united reform Jewish organizations in the United States (1819-1900); United States Jewish leader (born in Hungary) (1874-1949)"
            },
            {
                    "Wishy-washy", ""
            },
            {
                    "Withdrawn",
                    "Withdrawn - adj. tending to reserve or introspection; withdrawn from society; seeking solitude"
            },
            {
                    "Witty", "Witty - adj. combining clever conception and facetious expression"
            },
            {
                    "Worried",
                    "Worried - adj. mentally upset over possible misfortune or danger etc; afflicted with or marked by anxious uneasiness or trouble or grief"
            },
            {
                    "Wrong",
                    "Wrong - adj. based on or acting or judging in error; used of the side of cloth or clothing intended to face inward; not in accord with established usage or procedure; contrary to conscience or morality or law; not appropriate for a purpose or occasion; not correct; not in conformity with fact or truth; not functioning properly; badly timed;adv. in an incorrect manner; noun any harm or injury resulting from a violation of a legal right; that which is contrary to the principles of justice or law; verb treat unjustly; do wrong to"
            },
            {
                    "Young",
                    "Young - adj. being in its early stage; (used of living things especially persons) in an early period of life or development or growth; (of crops) harvested at an early stage of development; before complete maturity; not tried or tested by experience;suggestive of youth; vigorous and fresh; noun any immature animal; young people collectively; United States religious leader of the Mormon Church after the assassination of Joseph Smith; he led the Mormon exodus from Illinois to Salt Lake City, Utah (1801-1877); United States baseball player and famous pitcher (1867-1955); English poet (1683-1765); United States jazz tenor saxophonist (1909-1959); British physicist and Egyptologist; he revived the wave theory of light and proposed a three-component theory of color vision; he also played an important role in deciphering the hieroglyphics on the Rosetta Stone (1773-1829);United States civil rights leader (1921-1971); United States film and television actress (1913-2000)"
            },
            {
                    "Zany",
                    "Zany - adj. like a clown; ludicrous, foolish; noun a buffoon in one of the old comedies; imitates others for ludicrous effect; a man who is a stupid incompetent fool"
            }
    };

    List<String[]> personalityTraitsListO = new ArrayList<String[]>();
    */
    
    public PersonalityTraits() {
    	super("random");
    	
    	/* REPLACED 
        personalityTraitsListOld = Arrays.asList(personalityTraitsOld);
    	*/
    	
        /* REPLACED v2 
    	personalityTraitsListO = Arrays.asList(personalityTraitsO);
    	*/
    }
    
    public void addImportedPersonalityTrait(String sId, String name, String description) {
    	personalityTraits.put(sId, new PersonalityTrait(sId, name, description) );
    }
    
    
    
    
    /* REPLACED v2
    public int genOnePersonalityTraitId() {
        Random r = new Random();
        return r.nextInt(personalityTraitsListO.size());
    }
    
    public String[] getOnePersonalityTraitArray(int id) {
        return personalityTraitsListO.get(id);
    }
    
    public String getOnePersonalityTraitString(int id, int type) {
        return personalityTraitsListO.get(id)[type];
    }
    */
    
    /* REPLACED 
    private String[] personalityTraitsOld = {
            "Able",
            "Absent-minded",
            "Active",
            "Adventurous",
            "Affable",
            "Affected",
            "Affectionate",
            "Afraid",
            "Aggressive",
            "Alert",
            "Ambitious",
            "Amiable",
            "Angry",
            "Animated",
            "Annoyed",
            "Anxious",
            "apologetic",
            "Appreciative",
            "Argumentative",
            "Arrogant",
            "Attentive",
            "Austere",
            "Average",
            "Awkward",
            "Babyish",
            "Bad",
            "Bashful",
            "Bewildered",
            "Blasé",
            "Blowhard",
            "Boastful",
            "Bold",
            "Boorish",
            "Bored",
            "Bossy",
            "Brainy",
            "Brave",
            "Bright",
            "Brilliant",
            "Brutish",
            "Busy",
            "Calm",
            "Candid",
            "Capable",
            "Carefree",
            "Careful",
            "Careless",
            "caring",
            "Caustic",
            "Cautious",
            "Changeable",
            "Charismatic",
            "Charming",
            "Cheerful",
            "Civilised",
            "Clever",
            "Clumsy",
            "Coarse",
            "Cold-hearted",
            "Commitment-phobe",
            "Committed",
            "Communicative",
            "compassionate",
            "Competent",
            "Complacent",
            "Conceited",
            "Concerned",
            "Confident",
            "Confused",
            "Conscientious",
            "Considerate",
            "Consistent",
            "Contented",
            "Cooperative",
            "Courageous",
            "Cowardly",
            "Crafty",
            "Creative",
            "Critical",
            "Cross",
            "Cruel",
            "Cultured",
            "Curious",
            "Dainty",
            "Dangerous",
            "Daring",
            "Daring",
            "Dark",
            "Dauntless",
            "Decisive",
            "Deferential",
            "Demanding",
            "Demanding",
            "Dependable",
            "Depressed",
            "Desiccated",
            "Despondent",
            "Determined",
            "Devoted",
            "Diligent",
            "Disaffected",
            "Disagreeable",
            "Discerning",
            "discontented",
            "Discouraged",
            "Discreet",
            "Dishonest",
            "Disillusioned",
            "Disloyal",
            "Dismayed",
            "Disorganized",
            "Disparaging",
            "Disrespectful",
            "Dissatisfied",
            "Distressed",
            "Domineering",
            "Doubtful",
            "Dreamer",
            "Dreamy",
            "Dull",
            "Dutiful",
            "Eager",
            "Easygoing",
            "Effervescent",
            "Efficient",
            "Eloquent",
            "Embarrassed",
            "Encouraging",
            "Energetic",
            "Enthusiastic",
            "Equable",
            "Ethical",
            "Evil",
            "Exacting",
            "Excessive",
            "Excitable",
            "Excited",
            "Expert",
            "Exuberant",
            "Facetious",
            "Fair",
            "Faithful",
            "Faithless",
            "Fanciful",
            "Fearful",
            "Fearless",
            "Feisty",
            "ferocious",
            "Fidgety",
            "Fierce",
            "Fighter",
            "Finicky",
            "Flexible",
            "Foolish",
            "Forgetful",
            "Forgiving",
            "Formal",
            "Fortunate",
            "Foul",
            "Frank",
            "fresh",
            "friendly",
            "Frightened",
            "Frustrated",
            "Fun loving",
            "Funny",
            "Furious",
            "Fussy",
            "Garrulous",
            "Generous",
            "Gentle",
            "Giddy",
            "Gives up easily",
            "Giving",
            "Glamorous",
            "Gloomy",
            "Glum",
            "Good",
            "graceful",
            "Greedy",
            "Gregarious",
            "Grouchy",
            "Grumpy",
            "Guilty",
            "Gullible",
            "Handsome",
            "Happy",
            "Hard-working",
            "Hardy",
            "Harried",
            "Harsh",
            "Hateful",
            "Haughty",
            "Healthy",
            "Helpful",
            "Hesitant",
            "Honest",
            "Hopeful",
            "Hopeless",
            "Hospitable",
            "Hot-tempered",
            "Humble",
            "Humorous",
            "Ignorant",
            "Ill-bred",
            "Imaginative",
            "Immaculate",
            "Immature",
            "immobile",
            "Impartial",
            "Impatient",
            "impolite",
            "Impudent",
            "Impulsive",
            "Inactive",
            "Inconsiderate",
            "Inconsistent",
            "Indecisive",
            "independent",
            "Indiscriminate",
            "Indolent",
            "Industrious",
            "Inefficient",
            "Inimitable",
            "Innocent",
            "Insecure",
            "Insincere",
            "Insipid",
            "Insistent",
            "Insolent",
            "Intelligent",
            "Intolerant",
            "Intrepid",
            "Inventive",
            "Jealous",
            "Jolly",
            "Jovial",
            "Joyful",
            "Keen",
            "Kind",
            "Kindly",
            "Lackadaisical",
            "Languid",
            "Lazy",
            "Leader",
            "Lean",
            "Left-brain",
            "Liar",
            "licentious",
            "Light",
            "Light-hearted",
            "Limited",
            "Lively",
            "Logical",
            "Lonely",
            "Loquacious",
            "Loud",
            "Lovable",
            "Loves challenge",
            "Loving",
            "Loyal",
            "Lucky",
            "Malicious",
            "Mannerly",
            "Mature",
            "Mean",
            "Meek",
            "Merciful",
            "Messy",
            "Meticulous",
            "Mischievous",
            "Miserable",
            "Moody",
            "Mysterious",
            "Nagging",
            "Naïve",
            "Naughty",
            "Neat",
            "Negligent",
            "Nervous",
            "Nice",
            "No purpose",
            "Noisy",
            "Not trustworthy",
            "Obedient",
            "Obese",
            "Obliging",
            "Observant",
            "Open",
            "Optimistic",
            "Organised",
            "Outspoken",
            "Overweight",
            "Patient",
            "Patriotic",
            "Peaceful",
            "Perserverant",
            "Persistent",
            "Persuasive",
            "Perverse",
            "Pessimistic",
            "Picky",
            "Pitiful",
            "Plain",
            "Playful",
            "pleasant",
            "Pleasing",
            "Polite",
            "Poor",
            "Popular",
            "Positive",
            "Precise",
            "Pretty",
            "Prim",
            "primitive",
            "Proper",
            "Proud",
            "Prudent",
            "Punctual",
            "Purposeful",
            "Quarrelsome",
            "Quick",
            "Quick-tempered",
            "Quiet",
            "Rational",
            "Rawboned",
            "Reasonable",
            "Reckless",
            "Relaxed",
            "Reliable",
            "Religious",
            "Repugnant",
            "Repulsive",
            "Reserved",
            "Resourceful",
            "Respectful",
            "Responsible",
            "Restless",
            "Rich",
            "Rigid",
            "Risk-taking",
            "Rough",
            "rowdy",
            "Rude",
            "Ruthless",
            "Sad",
            "Safe",
            "Satisfied",
            "Scared",
            "Scatty",
            "Scheming",
            "Scrawny",
            "Scruffy",
            "Secretive",
            "Secure",
            "Self-centered",
            "Self-confident",
            "Self-controlling",
            "Selfish",
            "Sensitive",
            "Sentimental",
            "Serious",
            "Sharp",
            "Sharp-witted",
            "Shiftless",
            "Short",
            "Shrewd",
            "Shy",
            "Silly",
            "Simple",
            "simple-minded",
            "Sincere",
            "skillful",
            "Sly",
            "Smart",
            "Sneaky",
            "Soft-hearted",
            "Solitary",
            "Sorry",
            "Spendthrift",
            "Spoiled",
            "Sterile",
            "Stern",
            "Stingy",
            "Strange",
            "Strict",
            "Strong",
            "Stubborn",
            "Studious",
            "Submissive",
            "Successful",
            "Supersticious",
            "Supportive",
            "Suspicious",
            "Sweet",
            "Tactful",
            "Tactless",
            "Talented",
            "Talkative",
            "Tall",
            "Tardy",
            "Temperate",
            "Thankful",
            "Thorough",
            "Thoughtful",
            "Thoughtless",
            "Thrifty",
            "Thrilled",
            "Timid",
            "Tired",
            "Tireless",
            "Tolerant",
            "Touchy",
            "Tough",
            "Trusting",
            "Trustworthy",
            "Truthful",
            "Ugly",
            "Unconcerned",
            "Uncoordinated",
            "Undependable",
            "Understanding",
            "Unforgiving",
            "Unfriendly",
            "Ungrateful",
            "Unhappy",
            "Unkind",
            "Unmerciful",
            "Unselfish",
            "Unsuitable",
            "Upset",
            "useful",
            "vacant",
            "Violent",
            "Virtuous",
            "Warm",
            "Weak",
            "Wicked",
            "Wild",
            "Wise",
            "Wishy-washy",
            "Withdrawn",
            "Witty",
            "Worried",
            "Wrong",
            "Young",
            "Zany"
    };
    List<String> personalityTraitsListOld = new ArrayList<String>();
    public String getOnePersonalityTraitOld() {
        Random r = new Random();
        int random = r.nextInt(personalityTraitsListOld.size());
        return personalityTraitsListOld.get(random);
    }
    */
    
}
