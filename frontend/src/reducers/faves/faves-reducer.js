import * as FavesActions from './actions'

const initialState = {
  faves: [
    //JSON.parse(`{"id":126776,"from_id":-46861238,"to_id":-46861238,"date":1514061580,"marked_as_ads":0,"post_type":"post","text":"","attachment":{"type":"photo","photo":{"pid":456249945,"aid":-7,"owner_id":-46861238,"user_id":100,"src":"https://pp.userapi.com/c7001/v7001563/408d3/Rd1_nZtTfZs.jpg","src_big":"https://pp.userapi.com/c7001/v7001563/408d4/CpSY5K3Htgo.jpg","src_small":"https://pp.userapi.com/c7001/v7001563/408d2/foUKq3BkIy8.jpg","width":482,"height":563,"text":"","created":1514061580,"post_id":126776,"access_key":"897d906a9acca9a05b"}},"attachments":[{"type":"photo","photo":{"pid":456249945,"aid":-7,"owner_id":-46861238,"user_id":100,"src":"https://pp.userapi.com/c7001/v7001563/408d3/Rd1_nZtTfZs.jpg","src_big":"https://pp.userapi.com/c7001/v7001563/408d4/CpSY5K3Htgo.jpg","src_small":"https://pp.userapi.com/c7001/v7001563/408d2/foUKq3BkIy8.jpg","width":482,"height":563,"text":"","created":1514061580,"post_id":126776,"access_key":"897d906a9acca9a05b"}}],"post_source":{"type":"api","platform":"iphone"},"comments":{"count":0,"can_post":0},"likes":{"count":519,"user_likes":1,"can_like":0,"can_publish":1},"reposts":{"count":24,"user_reposted":0}}`),
    //JSON.parse(`{"id":140968,"from_id":-45091870,"to_id":-45091870,"date":1513507048,"marked_as_ads":0,"post_type":"post","text":"Ёмких двустиший пост.<br><br>не надо делать мне как лучше, <br>оставьте мне как хорошо <br>*** <br>я не хотела вас обидеть, <br>случайно просто повезло <br>*** <br>поскольку времени немного, <br>я вкратце матом объясню <br>*** <br>башка сегодня отключилась, <br>не вся, конечно, — есть могу <br>*** <br>следить стараюсь за фигурой, <br>чуть отвлекусь — она жуёт <br>*** <br>шаман за скверную погоду <br>недавно в бубен получил <br>*** <br>всё вроде с виду в шоколаде, <br>но если внюхаться — то нет <br>*** <br>обидеть Таню может каждый, <br>не каждый может убежать <br>*** <br>ищу приличную работу, <br>но чтоб не связана с трудом <br>*** <br>мои намеренья прекрасны, <br>пойдёмте, тут недалеко <br>*** <br>я за тебя переживаю — <br>вдруг у тебя всё хорошо <br>*** <br>держи вот этот подорожник — <br>щас врежу, сразу приложи <br>*** <br>я понимаю что вам нечем, <br>но всё ж попробуйте понять <br>*** <br>о, приключеньями запахло, <br>спускаю жопу с поводка <br>*** <br>мы были б идеальной парой, <br>конечно, если бы не ты <br>*** <br>как говорится, всё проходит, <br>но может кое что застрять <br>*** <br>кого хочу я осчастливить, <br>тому уже спасенья нет <br>*** <br>а ты готовить-то умеешь? <br>— я вкусно режу колбасу <br>*** <br>звони почаще — мне приятно <br>на твой \\"пропущенный\\" смотреть <br>*** <br>зачем учить нас, как работать, <br>вы научитесь, как платить <br>*** <br>характер у меня тяжёлый, <br>всё потому, что золотой <br>*** <br>чтоб дело мастера боялось, <br>он знает много страшных слов <br>*** <br>вы мне хотели жизнь испортить? <br>спасибо, справилась сама <br>*** <br>её сбил конь средь изб горящих, <br>она нерусскою была <br>*** <br>когда все крысы убежали, <br>корабль перестал тонуть <br>*** <br>дела идут пока отлично, <br>поскольку к ним не приступал <br>*** <br>работаю довольно редко, <br>а недовольно каждый день <br>*** <br>была такою страшной сказка, <br>что дети вышли покурить <br>*** <br>когда на планы денег нету, <br>они становятся мечтой <br>*** <br>женат два раза неудачно — <br>одна ушла, вторая – нет <br>*** <br>есть всё же разум во вселенной, <br>раз не выходит на контакт <br>*** <br>уж вроде ноги на исходе, <br>а юбка всё не началась <br>*** <br>я попросил бы вас остаться, <br>но вы ж останетесь, боюсь <br>*** <br>для женщин нет такой проблемы, <br>которой им бы не создать <br>*** <br>Олегу не везёт настолько, <br>что даже лифт идёт в депо <br>*** <br>меня запомните весёлым, <br>а завтра я начну ремонт <br>*** <br>зевну ,укроюсь с головою, <br>будильник заведу на март <br>*** <br>мы называем это жизнью, <br>а это просто список дел <br>*** <br>всё то, что нас не убивает, <br>богаче делает врачей <br>*** <br>и жили счастливо и долго... <br>он долго, счастливо она <br>*** <br>я не туплю, а экономно <br>расходую потенциал <br>*** <br>мне психиатр сказал: присядьте, <br>щас успокоюсь и начнём <br>*** <br>в народ ходили депутаты <br>лишь только по большой нужде <br>*** <br>сержант почти поймал бандита, <br>но тот по званью выше был <br>*** <br>в постели ты великолепен, <br>все две минуты просто бог <br>*** <br>пришла ко мне сестра таланта, <br>но не достала до звонка <br>*** <br>я ненавижу власть и деньги, <br>когда они в чужих руках <br>*** <br>Олег весь день крутил баранку, <br>потом не выдержал и съел","attachment":{"type":"photo","photo":{"pid":456286382,"aid":-7,"owner_id":-45091870,"user_id":100,"src":"https://pp.userapi.com/c840738/v840738392/32197/EO4i15WrwmM.jpg","src_big":"https://pp.userapi.com/c840738/v840738392/32198/BF_P6RtPddw.jpg","src_small":"https://pp.userapi.com/c840738/v840738392/32196/wTem9Mihm50.jpg","src_xbig":"https://pp.userapi.com/c840738/v840738392/32199/6uMV4O3gXMg.jpg","src_xxbig":"https://pp.userapi.com/c840738/v840738392/3219a/RlOAl_4DGc4.jpg","src_xxxbig":"https://pp.userapi.com/c840738/v840738392/3219b/KFEJpV-eNLY.jpg","width":1334,"height":1334,"text":"","created":1513507048,"post_id":140968,"access_key":"b2a092d36bbba94ce0"}},"attachments":[{"type":"photo","photo":{"pid":456286382,"aid":-7,"owner_id":-45091870,"user_id":100,"src":"https://pp.userapi.com/c840738/v840738392/32197/EO4i15WrwmM.jpg","src_big":"https://pp.userapi.com/c840738/v840738392/32198/BF_P6RtPddw.jpg","src_small":"https://pp.userapi.com/c840738/v840738392/32196/wTem9Mihm50.jpg","src_xbig":"https://pp.userapi.com/c840738/v840738392/32199/6uMV4O3gXMg.jpg","src_xxbig":"https://pp.userapi.com/c840738/v840738392/3219a/RlOAl_4DGc4.jpg","src_xxxbig":"https://pp.userapi.com/c840738/v840738392/3219b/KFEJpV-eNLY.jpg","width":1334,"height":1334,"text":"","created":1513507048,"post_id":140968,"access_key":"b2a092d36bbba94ce0"}}],"post_source":{"type":"vk"},"comments":{"count":0,"can_post":0},"likes":{"count":1453,"user_likes":1,"can_like":0,"can_publish":1},"reposts":{"count":312,"user_reposted":0}}`),
  ],
  totalCount: 0,
  fetchInProgress: false,
  fetchError: null
}

export default function favesReducer(state = initialState, action) {
  switch (action.type) {
    case FavesActions.FAVES_FETCH_REQUEST:
      return {
        ...state,
        fetchInProgress: true,
        fetchError: false
      }
    case FavesActions.FAVES_FETCH_SUCCESS:
      // payload: Array = response.response = [ count, ...faves ]
      let faves = action.payload.slice(1)
      return {
        ...state,
        totalCount: action.payload[0],
        userData: [ ...state.faves, ...faves ],
        fetchInProgress: false,
        fetchError: false
      }
    case FavesActions.FAVES_FETCH_FAILURE:
      return {
        ...state,
        fetchInProgress: false,
        fetchError: action.payload
      }
    default:
      return state
  }
}